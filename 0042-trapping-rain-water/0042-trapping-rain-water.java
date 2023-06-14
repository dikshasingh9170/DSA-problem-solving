class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int max1=height[0];
        int max2=height[n-1];
        int i=1;
        int j=n-2;
        int ans=0;
        
        while(i<=j){
            if(max1<max2){
                if(height[i]>=max1){
                    max1=height[i];
                }
                else{
                    ans+=max1-height[i];
                }
                i++;
            }
            else{
                if(max2<=height[j]){
                    max2=height[j];
                }
                else{
                    ans+=max2-height[j];
                }
                j--;
            }
        }
        return ans;
    }
}
