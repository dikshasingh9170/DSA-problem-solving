class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int[] i:roads){
            arr.get(i[0]).add(new Pair(i[1],i[2]));
            arr.get(i[1]).add(new Pair(i[0],i[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.dist,b.dist));
        long[] dist=new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] cnt=new int[n];
        Arrays.fill(cnt,0);
        int MOD = 1_000_000_007;
        pq.add(new Pair(0,0));
        dist[0]=0;
        cnt[0]=1;
        while(!pq.isEmpty()){
            Pair x=pq.poll();
            int node=x.node;
            long distance=x.dist;
            if(distance>dist[node])continue;
            for(Pair p:arr.get(node)){
                int pnode=p.node;
                long pdist=p.dist;
                long currDist=distance+pdist;
                if(currDist<dist[pnode]){
                    dist[pnode]=currDist;
                    cnt[pnode]=cnt[node];
                    pq.add(new Pair(pnode,currDist));
                }
                else if(currDist==dist[pnode]){
                    cnt[pnode]=(cnt[pnode]+cnt[node])%MOD;
                }
            }
        }
        return cnt[n-1];

    }
}
class Pair{
    int node;
    long dist;
    public Pair(int node,long dist){
        this.node=node;
        this.dist=dist;
    }
}