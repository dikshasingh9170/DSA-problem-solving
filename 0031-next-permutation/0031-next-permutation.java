class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1 || nums==null)return;
        if (nums.length <= 2) {
            swap(nums, 0, 1);
        } 
        else{
            int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) 
        {
            i--;
        }
        int j=nums.length-1;
        if(i>=0){
            while(nums[i]>=nums[j] && j>i){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
        swap(nums,i++,j--);
        }
    }
}
