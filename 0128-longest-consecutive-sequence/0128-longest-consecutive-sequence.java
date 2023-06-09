class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);int curr=0;int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]==1){
                curr++;
            }
            else if(nums[i]-nums[i-1]==0){
                continue;
            }
            else{
                max=Math.max(curr,max);
                curr=0;
            }
        }
        max=Math.max(max,curr);
        return max+1;
    }
}