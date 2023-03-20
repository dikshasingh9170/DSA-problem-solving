class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[i][j];
                    continue;
                }int x=grid[i][j],y=grid[i][j];
                if(i>0){
                    x+=dp[i-1][j];
                }
                else{
                    x=Integer.MAX_VALUE;
                }
                if(j>0){
                    y+=dp[i][j-1];
                }
                else{
                    y=Integer.MAX_VALUE;
                }
                dp[i][j]=Math.min(x,y);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}