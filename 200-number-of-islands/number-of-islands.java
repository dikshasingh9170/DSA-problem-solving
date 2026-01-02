class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
    public void bfs(int row,int col,char[][] grid,int[][] vis){
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{row,col});
        vis[row][col]=1;
        while(!q.isEmpty()){
            int[] res=q.poll();
            row=res[0];
            col=res[1];
            if(isValid(row+1,col,grid,vis)){
                vis[row+1][col]=1;
                q.add(new int[]{row+1,col});
            }
            if(isValid(row-1,col,grid,vis)){
                vis[row-1][col]=1;
                q.add(new int[]{row-1,col});
            }
            if(isValid(row,col+1,grid,vis)){
                vis[row][col+1]=1;
                q.add(new int[]{row,col+1});
            }
            if(isValid(row,col-1,grid,vis)){
                vis[row][col-1]=1;
                q.add(new int[]{row,col-1});
            }
        }
    }
    public boolean isValid(int row,int col,char[][] grid,int[][] vis){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && vis[row][col]==0 && grid[row][col]=='1'){
            return true;
        }
        return false;
    }
}