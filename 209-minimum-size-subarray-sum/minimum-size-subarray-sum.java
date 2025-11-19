class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j=0;int currSum=0;int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            while(currSum>=target){
                min=Math.min(min,i-j+1);
                currSum-=nums[j];
                j++;
            }
        }
        return min== Integer.MAX_VALUE ? 0 :min;
    }
}