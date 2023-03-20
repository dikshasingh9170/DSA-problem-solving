class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                int x=0;int y=0;
                if(i>0){
                    x=dp[i-1][j];
                }
                if(j>0){
                    y=dp[i][j-1];
                }
                dp[i][j]=x+y;
            }
        }
        return dp[m-1][n-1];
    }
}