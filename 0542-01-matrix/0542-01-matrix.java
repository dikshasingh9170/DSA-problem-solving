class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair>q = new LinkedList<>();
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] ans = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        while(!q.isEmpty()){
            int row=q.peek().x;
            int col=q.peek().y;
            int d = q.poll().z;
            ans[row][col]=d;
            for(int i=0;i<4;i++){
                int nrow = row+di[i];
                int ncol = col+dj[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;
                    q.offer(new Pair(nrow,ncol,d+1));
                }
            }
        }
        return ans;
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