class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->x[2]-y[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        int[][] dirs={{0,-1},{-1,0},{1,0},{0,1}};
        boolean[][] visited = new boolean[n][n];
        while(!pq.isEmpty())
        {
            int[] x=pq.poll();
            int row=x[0];
            int col=x[1];
            int dis=x[2];
            if(row==n-1 && col==n-1)return dis;
            if(visited[row][col])continue;
            visited[row][col]=true;
            for(int[] dir:dirs){
                int nr=row+dir[0];
                int nc=col+dir[1];
                if(nr<0 || nr>=n || nc<0 || nc>=n){
                    continue;
                }
                if(visited[nr][nc])continue;
                int newDist=grid[nr][nc];
                int max=Math.max(dis,newDist);
                pq.add(new int[]{nr,nc,max});
            }
        }
        return -1;
    }
}