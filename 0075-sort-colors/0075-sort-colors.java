class Solution {
    public void sortColors(int[] nums) {
        int zero=0;int one=0;int two=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero++;
            }
            else if(nums[i]==1){
                one++;
            }
            else{
                two++;
            }
        }
        Arrays.fill(nums,0,zero,0);
        Arrays.fill(nums,zero,one+zero,1);
        Arrays.fill(nums,one+zero,one+zero+two,2);
    }
}