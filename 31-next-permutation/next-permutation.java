class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n<=1){
            return;
        }
        if(n==2){
            reverse(nums,0,n-1);
            return;
        }
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j=n-1;
            while(j>i && nums[j]<=nums[i]){
                j--;
            }
            int temp=nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
        }
        reverse(nums,i+1,n-1);
    }
    public void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    } 
}
