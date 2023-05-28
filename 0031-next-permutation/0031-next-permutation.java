class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        if(nums.length==2){
            swap(nums,0,1);
            return;
        }
        else{
            int i=nums.length-2;
            while(i>=0 && nums[i]>=nums[i+1]){
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
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
    public void reverse(int[] nums,int x,int y){
        while(x<y){
            swap(nums,x++,y--);
        }
    }
}
