class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int N=nums.length;
        int d=target;
	    int sum=0;
	    for(int i=0;i<N;i++){
	        sum+=nums[i];
	    }
        if((sum-d)%2!=0 || sum-d<0){
            return 0;
        }
	    sum=(sum-d)/2;
	    int[][] t=new int[N+1][sum+1];
        for(int i=0;i<=N;i++){
            t[i][0]=1;
        }
        for(int i=1;i<=sum;i++){
            t[0][i]=0;
        }
        for(int i=1;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j-nums[i-1]]+t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[N][sum];
    }
}