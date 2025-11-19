class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0, index = 0;
        int[] arr = new int[n1 + n2];
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr[index++] = nums1[i];
                i++;
            } else {
                arr[index++] = nums2[j];
                j++;
            }
        }
        while (i < n1) {
            arr[index++] = nums1[i++];
        }
        while (j < n2) {
            arr[index++] = nums2[j++];
        }
        double val = 0;
        int mid = arr.length;
        if (mid % 2 == 1) {
            val = (double) arr[mid/2];
        } else {
            if(mid==0){
                val = (double) arr[mid/2];
            }
            else{
                val = (double) (arr[mid/2] + arr[(mid/2) - 1]) / 2;                
            }
        }
        return val;
    }
}