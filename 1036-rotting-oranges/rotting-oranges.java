class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sr=0;int sc=0;
        Queue<int[]> q = new ArrayDeque<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    cnt++;
                }
            }
        } int min=0;
        while (!q.isEmpty() && cnt>0) {
            int size=q.size();
            min++;
            while(size-->0){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                if (isValid(grid, r - 1, c)) {
                    grid[r - 1][c] =2;
                    cnt--;
                    q.add(new int[]{r - 1, c});
                }

                if (isValid(grid, r + 1, c)) {
                    grid[r + 1][c] = 2;
                    cnt--;
                    q.add(new int[]{r + 1, c});
                }

                if (isValid(grid, r, c - 1)) {
                    grid[r][c - 1] = 2;
                    cnt--;
                    q.add(new int[]{r, c - 1});
                }

                if (isValid(grid, r, c + 1)) {
                    grid[r][c + 1] = 2;
                    cnt--;
                    q.add(new int[]{r, c + 1});
                }
            }
        }
        return cnt==0?min:-1;
    }
    private boolean isValid(int[][] image, int r, int c) {
        return r >= 0 && r < image.length &&
               c >= 0 && c < image[0].length &&
               image[r][c]==1;
    }
    
}