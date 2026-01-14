class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid==null || grid.length==0)return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1) && grid[i][j]==1){
                    dfs(i,j,grid);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]!=1){
            return;
        }
        grid[i][j]=2;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
    }
}