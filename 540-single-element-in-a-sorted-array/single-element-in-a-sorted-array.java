class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i-1]!=nums[i] && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        if(n>=2 && nums[n-1]!=nums[n-2])return nums[n-1];
        return -1;
    }
}