class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return cost[0];
        }
        if(n==2){
            return Math.min(cost[1],cost[0]);
        }
        int prev1=cost[0];
        int prev2=cost[1];
        int curr=0;
        for(int i=2;i<n;i++){
            curr=Math.min(prev1,prev2)+cost[i];
            prev1=prev2;
            prev2=curr;
        }
        return Math.min(prev1,curr);
    }
}