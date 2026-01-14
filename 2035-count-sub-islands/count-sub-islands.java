class Solution {
    boolean subLand;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int cnt=0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){
                if(grid2[i][j]==1){
                    subLand=true;
                    dfs(i,j,grid1,grid2);
                    if(subLand)cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int i,int j,int[][] grid1,int[][] grid2){
        if(i<0 || j<0 || i>=grid1.length || j>=grid1[0].length || grid2[i][j]!=1){
            return;
        }
        if(grid1[i][j]!=grid2[i][j]){
            subLand=false;
        }
        grid2[i][j]=0;
        dfs(i,j-1,grid1,grid2);
        dfs(i,j+1,grid1,grid2);
        dfs(i-1,j,grid1,grid2);
        dfs(i+1,j,grid1,grid2);
    }
}