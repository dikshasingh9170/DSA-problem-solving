class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            for(int j=0;j<obstacleGrid[0].length;j++){
                if(i>=0 && j>=0 && obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }int x=0,y=0;
                if(i>0){
                    x=dp[i-1][j];
                }
                if(j>0){
                    y=dp[i][j-1];
                }
                dp[i][j]=x+y;
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}