class Solution {
    public int trap(int[] height) {
        int n=height.length;
         int[] max1=new int[n];
        int[] max2=new int[n];
        max1[0]=height[0];
        max2[n-1]=height[n-1];
        int k1=0,k2=0;
        for(int i=1;i<n;i++){
                max1[i]=Math.max(height[i],max1[i-1]);
        }
        for(int i=n-2;i>=0;i--){
                max2[i]=Math.max(height[i],max2[i+1]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            count+=(long)Math.min(max1[i],max2[i])-height[i];
        }
        return count;
    }
}