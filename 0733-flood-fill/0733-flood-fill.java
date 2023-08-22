//Time Complexity: 
//O(N), where N is the number of pixels in the image. We might process every pixel.
//Space Complexity: O(N), the size of the implicit call stack when calling flood.
/*class Solution {
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
}*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image; 
        dfs(sr,sc,image,ans,color,image[sr][sc]);
        return ans;
    }
    public void dfs(int i,int j,int[][] image,int[][] ans,int Color,int oldcolor){
        ans[i][j]=Color;
        int n=image.length;
        int m=image[0].length;
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1}; 
        for(int k=0;k<4;k++){
            int nrow = i + delRow[k]; 
            int ncol = j + delCol[k]; 
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && 
            image[nrow][ncol] == oldcolor && ans[nrow][ncol] != Color) {
                dfs(nrow,ncol,image,ans,Color,oldcolor); 
            }
        }
    }
}