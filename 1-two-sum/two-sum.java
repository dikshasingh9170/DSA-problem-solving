class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int n=nums.length;
        int i=0,j=n-1;
        int sum=0;
        while(i<j){
            sum=nums[i]+nums[j];  
            if(sum==target){
                res[0]=i;
                res[1]=j;
                break;
            }
            else if(i!=j-1){
                j--;
            }
            else{
                i++;
                j=n-1;
            }
        }
        return res;
    }
}