class Solution {
    public void nextPermutation(int[] nums) {
        int idx=-1;int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,n-1);
        }else{
            for(int i=n-1;i>idx;i--){
                if(nums[i]>nums[idx]){
                    swap(nums,i,idx);
                    break;
                }
            }
            reverse(nums,idx+1,n-1);
        }
    }
    public void reverse(int[] nums,int x,int y){
        while(x<y){
            swap(nums,x++,y--);
        }
    }
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}