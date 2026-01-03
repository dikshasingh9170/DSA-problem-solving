class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        boolean[][] vis=new boolean[n][m];
        bfs(image,sr,sc,image[sr][sc],color,vis);
        return image;
    }
    public void bfs(int[][] image, int sr, int sc, int currColor, int color,boolean[][] vis){
        Queue<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sr,sc,currColor});
        image[sr][sc]=color;
        vis[sr][sc]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            sr=curr[0];
            sc=curr[1];
            if(isValid(image,sr-1,sc,curr[2],vis)){
                vis[sr-1][sc]=true;
                image[sr-1][sc]=color;
                q.add(new int[]{sr-1,sc,curr[2]});
            }
            if(isValid(image,sr+1,sc,curr[2],vis)){
                vis[sr+1][sc]=true;
                image[sr+1][sc]=color;
                q.add(new int[]{sr+1,sc,curr[2]});
            }
            if(isValid(image,sr,sc-1,curr[2],vis)){
                vis[sr][sc-1]=true;
                image[sr][sc-1]=color;
                q.add(new int[]{sr,sc-1,curr[2]});
            }
            if(isValid(image,sr,sc+1,curr[2],vis)){
                vis[sr][sc+1]=true;
                image[sr][sc+1]=color;
                q.add(new int[]{sr,sc+1,curr[2]});
            }
        }
    }
    public boolean isValid(int[][] image, int sr, int sc, int color,boolean[][] vis){
        if(sr>=0 && sr<image.length && sc>=0 && sc<image[0].length && color==image[sr][sc] && !vis[sr][sc]){
            return true;
        }
        return false;
    }
}