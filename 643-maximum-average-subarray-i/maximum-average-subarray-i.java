class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curr=0;
        for(int i=0;i<k;i++){
            curr+=nums[i];
        }
        double res=(double)curr/k;
        for(int i=1;i<=nums.length-k;i++){
            curr-=nums[i-1];
            curr+=nums[k+i-1];
            res=Math.max(res,(double)curr/k);
        }
        return res;
    }
}