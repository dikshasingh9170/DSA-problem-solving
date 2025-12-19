class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;int r=n-1;int ans=Math.min(height[l],height[r])*(r-l);
        while(l<r){
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
            ans=Math.max(ans,Math.min(height[l],height[r])*(r-l));
        }
        return ans;
    }
}