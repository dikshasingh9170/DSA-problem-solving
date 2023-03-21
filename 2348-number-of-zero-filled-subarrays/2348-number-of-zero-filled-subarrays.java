class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long curr=0;long max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                curr++;
                max+=curr;
            }
            else{
                curr=0;
            }
        }
        return max;
    }
}