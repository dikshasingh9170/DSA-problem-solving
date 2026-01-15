class Solution {
    public int searchInsert(int[] nums, int target) {
        int r=nums.length-1;
        int l=0;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if((mid>0 && target>nums[mid-1] && target<nums[mid])){
                return mid;
            }
            else if(mid<r && target>nums[mid] && target<=nums[mid+1]){
                return mid+1;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else if(nums[mid]<target){
                l=mid+1;
            }
        }

        return target>nums[nums.length-1]?nums.length:0;
    }
}