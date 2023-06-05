class Solution {
    public int majorityElement(int[] nums) {
        int count1=0;
        int candidate=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0){
                candidate=nums[i];
            }
            
            if(nums[i]==candidate){
                count1++;
            }
            else{
                count1--;
            }
        }
        return candidate;
    }
}