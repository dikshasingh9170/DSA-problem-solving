class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==1 && nums[0]==target){
            return 0;
        }
        if(n==1 && nums[0]!=target){
            return -1;
        }
        int left=0;int right=nums.length-1;int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else{
                if(target<=nums[right] && target>nums[mid]){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}