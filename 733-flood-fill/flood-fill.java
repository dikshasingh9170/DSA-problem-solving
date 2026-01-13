class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];
        if (originalColor == color) return image; 
        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=originalColor){
            return;
        }
        image[sr][sc]=newColor;
        dfs(image,sr+1,sc,originalColor,newColor);
        dfs(image,sr-1,sc,originalColor,newColor);
        dfs(image,sr,sc+1,originalColor,newColor);
        dfs(image,sr,sc-1,originalColor,newColor);
    }
}