class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {   
                if(dfs(i,0,graph,color)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(int i,int col,int[][] graph,int[] color){
        color[i] = col;
        for(int e:graph[i]){
            if(color[e]==-1){
                if(dfs(e,1-col,graph,color)==false)return false;
            }
            else if(color[e]==color[i]){
                return false;
            }
        }
        return true;
    }
}