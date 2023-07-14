/*class Solution {
    public int coinChange(int[] coins, int amount) {
        int W=amount;
        int n=coins.length;
        int[][] t=new int[n+1][W+1];
        for(int i=0;i<=W;i++){
            t[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            t[i][0]=0;
        }
        int j=1;
        for(int i=1;j<=W;j++){
            if(j%coins[i-1]==0){
                t[i][j]=j/coins[i-1];
            }
            else{
                t[i][j]=Integer.MAX_VALUE-1;
            }
        }
        for(int i=1;i<=n;i++){
            for( j=1;j<=W;j++){
                if(coins[i-1]<=j){
                    t[i][j]=Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }
                else if(coins[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
            }
        }
        if(t[n][W]==Integer.MAX_VALUE-1){
            t[n][W]=-1;
        }
        return t[n][W];
    }
}*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=solve(coins,amount,dp);
        if(ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public int solve(int[] coins,int amount,int[] dp){
        if(amount==0){
            return 0;
        }
        if(amount<0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount]!=-1){
            return dp[amount];
        }
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=solve(coins,amount-coins[i],dp);
            if(ans!=Integer.MAX_VALUE){
                mini=Math.min(mini,1+ans);
            }
        }
        dp[amount]=mini;
        return mini;
    }
}