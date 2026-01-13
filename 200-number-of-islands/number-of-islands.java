class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,char[][] grid,int[][] vis){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        vis[row][col]=1;
        while(!q.isEmpty()){
            int[] res=q.poll();
            row=res[0];
            col=res[1];
            if(isValid(row-1,col,grid,vis)){
                q.offer(new int[]{row-1,col});
                vis[row-1][col]=1;
            }
            if(isValid(row+1,col,grid,vis)){
                q.offer(new int[]{row+1,col});
                vis[row+1][col]=1;
            }
            if(isValid(row,col-1,grid,vis)){
                q.offer(new int[]{row,col-1});
                vis[row][col-1]=1;
            }
            if(isValid(row,col+1,grid,vis)){
                q.offer(new int[]{row,col+1});
                vis[row][col+1]=1;
            }
        }
    }
    public boolean isValid(int row,int col,char[][] grid,int[][] vis){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && vis[row][col]!=1 && grid[row][col]=='1'){
            return true;
        }
        return false;
    }
}