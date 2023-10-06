class Solution {
    public int maxProduct(int[] nums) {
        int maxLeft=1, maxRight=1;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(maxLeft==0) maxLeft=1;
            if(maxRight==0) maxRight=1;
            maxLeft*=nums[i];
            maxRight*=nums[n-i-1];
            max = Math.max(max, Math.max(maxLeft, maxRight));
        }
        return max;
    }
}
