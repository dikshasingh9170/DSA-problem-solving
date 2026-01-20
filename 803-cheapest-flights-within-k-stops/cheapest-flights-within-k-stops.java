class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q=new LinkedList<>();
        int steps=0;
        q.add(new int[]{src,0});
        while(!q.isEmpty() && steps<=k){
            int size=q.size();
            while(size-->0){
                int[] x=q.poll();
                int node=x[0];
                int distance=x[1];
                for(int[] e:adj.get(node)){
                    int enode=e[0];
                    int edist=e[1];
                    int currDist=distance+edist;
                    if(currDist<dist[enode]){
                        dist[enode]=currDist;
                        q.add(new int[]{enode,currDist});
                    }
                }
            }
            steps++;
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}