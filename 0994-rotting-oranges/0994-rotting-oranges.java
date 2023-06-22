class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<Pair>();int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        int fresh=0;int tm=0;
        int[] row={-1,0,1,0};
        int[] col={0,1,0,-1};
        while(!q.isEmpty()){
            int x=q.peek().x;
            int y=q.peek().y;
            int z=q.peek().z;
            tm=Math.max(tm,z);
            q.poll();
            for(int i=0;i<4;i++){
                int nrow=x+row[i];
                int ncol=y+col[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    q.offer(new Pair(nrow,ncol,z+1));
                    vis[nrow][ncol]=2;
                    fresh++;
                }
            }
        }
        return (cnt==fresh)?tm:-1;
    }
}
class Pair{
    int x,y,z;
    public Pair(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
}