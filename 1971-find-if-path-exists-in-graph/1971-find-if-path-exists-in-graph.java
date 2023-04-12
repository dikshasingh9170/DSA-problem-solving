class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            arr.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            arr.get(edges[i][0]).add(edges[i][1]);
            arr.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> q=new LinkedList<Integer>();
        boolean[] visited=new boolean[n];
        q.offer(source);
        visited[source]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int i:arr.get(u)){
                if(visited[i]==false){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        return visited[destination];
    }
}