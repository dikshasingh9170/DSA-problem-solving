class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int n=nums.length;
        int j=2;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[j-2]!=0){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}