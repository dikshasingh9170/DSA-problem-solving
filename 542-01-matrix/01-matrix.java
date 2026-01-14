class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        boolean[][] vis=new boolean[mat.length][mat[0].length];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    q.add(new int[]{i,j});
                }
                else{
                    vis[i][j]=false;
                }
            }
        }
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] res=q.poll();
                int row=res[0];
                int col=res[1];
                for(int[] dir:dirs){
                    int i=row+dir[0];
                    int j=col+dir[1];
                    if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)continue;
                    if(vis[i][j])continue;
                    vis[i][j]=true;
                    mat[i][j]=mat[row][col]+1;
                    q.add(new int[]{i,j});
                }
            }
        }
        return mat;
    }
}