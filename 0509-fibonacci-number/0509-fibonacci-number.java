/*class Solution {
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int prev1=0;
        int prev2=1;
        int curr=0;
        for(int i=2;i<=n;i++){
            curr=prev1+prev2;
            prev1=prev2;
            prev2=curr;
        }
        return curr;
    }
}*/
/*class Solution {
    public int fib(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n-1,dp);
    }
    public int solve(int i,int[] dp){
        if(i<=1){
            return i;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        dp[i]=solve(i-1,dp)+solve(i-2,dp);
        return dp[i];
    }
}*/
class Solution {
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}