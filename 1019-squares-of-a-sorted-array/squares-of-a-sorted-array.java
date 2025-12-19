class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] res=new int[nums.length];
        int l=0;int r=n-1;
        int leftSq=0;int rightSq=0;int pos=n-1;
        while(l<=r){
            leftSq=nums[l]*nums[l];
            rightSq=nums[r]*nums[r];
            if(leftSq<rightSq){
                res[pos]=rightSq;
                pos--;
                r--;
            }
            else{
                res[pos]=leftSq;
                pos--;
                l++;
            }
        }
        
        return res;
    }
}