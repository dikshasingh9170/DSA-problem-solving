class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int max=0;
        int area=0;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    area=dfs(i,j,grid);
                    max=Math.max(area,max);
                }
            }
        }
        return max;
    }
    public int dfs(int row,int col,int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0){
            return 0;
        }
        grid[row][col]=0;
        int area=1;
        area+=dfs(row-1,col,grid);
        area+=dfs(row+1,col,grid);
        area+=dfs(row,col+1,grid);
        area+=dfs(row,col-1,grid);
        return area;
    }
}