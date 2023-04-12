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
        int[][]vis=new int[n][m];
        int count=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(vis[row][col]==0 && grid[row][col]=='1'){
                    count++;
                    bfs(row,col,grid,vis);
                }
            }
        }
        return count;
    }
    public void bfs(int row,int col,char[][] grid,int visited[][]){
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length)return;
        if(grid[row][col]=='0')return;
        if(visited[row][col]==0){
            visited[row][col]=1;
            bfs(row+1,col,grid,visited);
            bfs(row-1,col,grid,visited);
            bfs(row,col+1,grid,visited);
            bfs(row,col-1,grid,visited);
            
        }
    }
}