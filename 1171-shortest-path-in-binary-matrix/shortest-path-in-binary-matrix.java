class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]==1 || grid[n-1][m-1]==1)return -1;
        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        vis[0][0]=true;
        q.add(new int[]{0,0});
        int dist=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] res=q.poll();
                int row=res[0];
                int col=res[1];
                if(row==n-1 && col==m-1)return dist;
                for(int[] dir:dirs){
                    int i=row+dir[0];
                    int j=col+dir[1];
                    if (i < 0 || j < 0 || i >= n || j >= m )continue;
                    if(vis[i][j] || grid[i][j]==1)continue;
                    vis[i][j]=true;
                    q.add(new int[]{i,j});
                }
            }
            dist++;
        }
        return -1;
    }
}