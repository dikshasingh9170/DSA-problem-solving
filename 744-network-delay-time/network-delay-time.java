class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:times){
            adj.get(e[0]).add(new Pair(e[2],e[1]));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        pq.add(new Pair(0,k));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int dis=curr.dist;
            int node=curr.node;
            if(dis>dist[node]){
                continue;
            }
            for(Pair e:adj.get(node)){
                int edis=e.dist;
                int enode=e.node;
                if(edis+dis<dist[enode]){
                    dist[enode]=edis+dis;
                    pq.add(new Pair(edis+dis,enode));
                }
            }
        }
        int maxTime=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)return -1;
            maxTime=Math.max(maxTime,dist[i]);
        }
        return maxTime;
    }
}
class Pair{
    int dist;
    int node;
    public Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
}