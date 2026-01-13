class Solution {
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    dfs(i,j,grid,vis);
                }
            }
        }
        return max;
    }
    public void dfs(int row,int col,int[][] grid,int[][] vis){
        Queue<int[]> q=new LinkedList<>();
        int cnt=0;
        q.offer(new int[]{row,col});
        vis[row][col]=1;
        cnt++;
        while(!q.isEmpty()){
            int[] res=q.poll();
            row=res[0];
            col=res[1];
            if(isValid(row-1,col,grid,vis)){
                q.offer(new int[]{row-1,col});
                cnt++;
                vis[row-1][col]=1;
            }
            if(isValid(row+1,col,grid,vis)){
                q.offer(new int[]{row+1,col});
                cnt++;
                vis[row+1][col]=1;
            }
            if(isValid(row,col-1,grid,vis)){
                q.offer(new int[]{row,col-1});
                cnt++;
                vis[row][col-1]=1;
            }
            if(isValid(row,col+1,grid,vis)){
                q.offer(new int[]{row,col+1});
                cnt++;
                vis[row][col+1]=1;
            }
        }
        max=Math.max(max,cnt);
    }
    public boolean isValid(int row,int col,int[][] grid,int[][] vis){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && vis[row][col]!=1 && grid[row][col]==1){
            return true;
        }
        return false;
    }
}