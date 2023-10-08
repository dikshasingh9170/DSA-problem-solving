class Solution {
    public int maxArea(int[] height) {
        int left=0;int right=height.length-1;
        int res=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            res=Math.max(res,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return res;
    }
}