class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,res,0,nums1.length);
        System.arraycopy(nums2,0,res,nums1.length,nums2.length);
        Arrays.sort(res);
        if(((res.length) & 1) ==1){
            double ans=(double)res[(res.length>>1)];
            return ans;
        }
        double ans=(double)(res[(res.length>>1)]+res[(res.length>>1)-1])/2;
        return ans;
    }
}