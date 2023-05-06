class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        if(oldcolor==color){
            return image;
        }
        flood(sr,sc,image,oldcolor,color);
        return image;
    }
    public void flood(int sr,int sc,int[][] image,int oldcolor,int color){
        int m=image.length;
        int n=image[0].length;
        if(sr>=0 && sr<m && sc>=0 && sc<n && image[sr][sc]==oldcolor && image[sr][sc]!=color){
            image[sr][sc]=color;
            flood(sr-1,sc,image,oldcolor,color);
            flood(sr+1,sc,image,oldcolor,color);
            flood(sr,sc-1,image,oldcolor,color);
            flood(sr,sc+1,image,oldcolor,color);
        }
        else{
            return;
        }
    }
}