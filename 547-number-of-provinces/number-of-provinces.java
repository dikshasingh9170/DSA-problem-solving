class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                provinces++;
                dfs(i, isConnected, vis);
            }
        }
        return provinces;
    }

    private void dfs(int start, int[][] isConnected, boolean[] vis) {
        vis[start]=true;
        for(int j=0;j<isConnected[start].length;j++){
            if(isConnected[start][j]==1 && !vis[j]){
                dfs(j,isConnected,vis);
            }
        }
    }
}
