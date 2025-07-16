class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(mid>=1 && mid<n-1 && nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid%2==1){
                if(mid>=1 && nums[mid-1]==nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }else{
                if(mid>=1 && nums[mid-1]!=nums[mid]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(n>=2 && nums[n-1]!=nums[n-2]){
            return nums[n-1];
        }
        return -1;
    }
}
// 3 3 7 7 10 11 11 
// 0 1 2 3  4  5  6
//mid=3
//left =4  right=6  mid=5
// right =5 mid=4


