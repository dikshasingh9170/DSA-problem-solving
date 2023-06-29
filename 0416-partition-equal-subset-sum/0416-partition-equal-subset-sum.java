class Solution {
    public boolean canPartition(int[] nums) {
        /*int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        return solve(0,nums,sum/2);
    }
    public boolean solve(int i,int[] nums,int sum){
        if(sum==0){
            return true;
        }
        if(i>=nums.length && sum!=0){
            return false;
        }
        if(nums[i]>sum){
            return solve(i+1,nums,sum);
        }
        return solve(i+1,nums,sum-nums[i]) || solve(i+1,nums,sum);
    }*/
    int sum=0;
    for(int i=0;i<nums.length;i++){
        sum+=nums[i];
    }
    if(sum%2!=0){
        return false;
    }   
        sum=sum/2;
        int N=nums.length;
    boolean[][] t=new boolean[N+1][sum+1];
        for(int i=0;i<=N;i++){
            t[i][0]=true;
        }
        for(int i=1;i<=sum;i++){
            t[0][i]=false;
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]] || t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[N][sum];  
    }
}
/*class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i : nums) sum+=i;
        if(sum%2!=0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i-j];
                }
            }
        }
        return dp[sum];
    }
}*/
