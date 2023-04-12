class Pair{
    int first;
    int second;
    Pair(int fst,int scnd){
        this.first=fst;
        this.second=scnd;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]=='1'){
                    count++;
                    grid[row][col]=0;
                    bfs(row,col,grid);
                }
            }
        }
        return count;
    }
    public void bfs(int row,int col,char[][] grid){
        grid[row][col]='0';
        if(isvalid(row+1,col,grid)){
            bfs(row+1,col,grid);
        }
        if(isvalid(row-1,col,grid)){
            bfs(row-1,col,grid);
        }
        if(isvalid(row,col-1,grid)){
            bfs(row,col-1,grid);
        }
        if(isvalid(row,col+1,grid)){
            bfs(row,col+1,grid);
        }
    }
      public boolean isvalid(int i,int j,char[][] grid){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]=='1'){
            return true;
        }
        return false;
    }
}