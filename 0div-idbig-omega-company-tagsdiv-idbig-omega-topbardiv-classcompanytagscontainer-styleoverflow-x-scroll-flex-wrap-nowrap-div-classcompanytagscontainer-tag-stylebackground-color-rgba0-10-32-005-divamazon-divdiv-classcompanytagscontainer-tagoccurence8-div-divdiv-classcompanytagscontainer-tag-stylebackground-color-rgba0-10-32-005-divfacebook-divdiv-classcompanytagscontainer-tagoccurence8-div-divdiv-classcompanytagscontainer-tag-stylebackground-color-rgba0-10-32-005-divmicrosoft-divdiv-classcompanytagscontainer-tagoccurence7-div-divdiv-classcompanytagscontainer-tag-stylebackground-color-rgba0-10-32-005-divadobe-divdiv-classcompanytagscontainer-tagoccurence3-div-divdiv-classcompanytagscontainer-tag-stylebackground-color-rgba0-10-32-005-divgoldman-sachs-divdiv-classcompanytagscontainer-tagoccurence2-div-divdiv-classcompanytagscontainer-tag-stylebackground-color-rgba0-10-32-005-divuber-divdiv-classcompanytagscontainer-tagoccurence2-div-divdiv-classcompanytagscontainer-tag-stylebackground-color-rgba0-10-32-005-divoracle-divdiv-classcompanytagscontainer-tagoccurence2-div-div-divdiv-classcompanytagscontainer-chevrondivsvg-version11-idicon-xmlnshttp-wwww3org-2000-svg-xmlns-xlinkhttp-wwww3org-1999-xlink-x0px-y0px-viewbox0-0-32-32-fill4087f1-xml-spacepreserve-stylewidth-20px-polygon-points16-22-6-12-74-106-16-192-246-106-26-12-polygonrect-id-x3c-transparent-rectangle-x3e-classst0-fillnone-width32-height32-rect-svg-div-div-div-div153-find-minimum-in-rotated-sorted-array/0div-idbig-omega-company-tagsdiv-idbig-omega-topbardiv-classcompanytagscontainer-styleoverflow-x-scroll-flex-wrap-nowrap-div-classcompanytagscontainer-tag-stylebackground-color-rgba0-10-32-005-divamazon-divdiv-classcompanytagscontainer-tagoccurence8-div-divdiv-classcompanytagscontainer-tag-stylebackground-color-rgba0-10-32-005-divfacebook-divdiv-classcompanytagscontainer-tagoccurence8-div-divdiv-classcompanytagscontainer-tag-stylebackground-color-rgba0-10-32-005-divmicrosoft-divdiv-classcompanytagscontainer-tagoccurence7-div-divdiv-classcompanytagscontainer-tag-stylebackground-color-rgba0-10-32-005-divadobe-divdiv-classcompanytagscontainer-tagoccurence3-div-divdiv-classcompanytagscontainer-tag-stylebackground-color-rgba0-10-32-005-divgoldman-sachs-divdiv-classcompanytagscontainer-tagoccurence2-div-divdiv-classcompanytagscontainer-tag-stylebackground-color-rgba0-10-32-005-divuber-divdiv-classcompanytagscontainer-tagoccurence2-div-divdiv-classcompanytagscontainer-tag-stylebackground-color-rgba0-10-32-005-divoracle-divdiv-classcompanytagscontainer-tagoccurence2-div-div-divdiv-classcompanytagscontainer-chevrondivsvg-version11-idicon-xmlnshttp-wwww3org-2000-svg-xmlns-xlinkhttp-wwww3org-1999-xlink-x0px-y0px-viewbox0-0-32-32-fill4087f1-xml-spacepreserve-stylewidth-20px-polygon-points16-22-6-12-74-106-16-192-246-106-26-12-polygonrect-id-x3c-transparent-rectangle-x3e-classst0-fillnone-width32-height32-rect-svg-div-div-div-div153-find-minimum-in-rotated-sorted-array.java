class Solution {
    public int findMin(int[] nums) {
        int left=0;int right=nums.length-1;int mini=Integer.MAX_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[left]<=nums[mid]){
                mini=Math.min(mini,nums[left]);
                left=mid+1;
            }
            else{
                if(nums[mid]<=nums[right]){
                    mini=Math.min(mini,nums[mid]);
                    right=mid-1;
                }
            }
        }
        return mini;
    }
}