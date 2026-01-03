class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];
        if (originalColor == color) return image; 
        bfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int originalColor, int newColor) {

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = newColor; 

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if (isValid(image, r - 1, c, originalColor)) {
                image[r - 1][c] = newColor;
                q.add(new int[]{r - 1, c});
            }

            if (isValid(image, r + 1, c, originalColor)) {
                image[r + 1][c] = newColor;
                q.add(new int[]{r + 1, c});
            }

            if (isValid(image, r, c - 1, originalColor)) {
                image[r][c - 1] = newColor;
                q.add(new int[]{r, c - 1});
            }

            if (isValid(image, r, c + 1, originalColor)) {
                image[r][c + 1] = newColor;
                q.add(new int[]{r, c + 1});
            }
        }
    }

    private boolean isValid(int[][] image, int r, int c, int originalColor) {
        return r >= 0 && r < image.length &&
               c >= 0 && c < image[0].length &&
               image[r][c] == originalColor;
    }
}
