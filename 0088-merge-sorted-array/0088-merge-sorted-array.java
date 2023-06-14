//O(n)  space O(m+n)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;
        int j=n-1;
        int i=m-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }
            else{
                nums1[k--]=nums2[j--];
            }
        }
    }
}
//{1,2,3,0,0,0}    {2,5,6}
//k=5; j=2; i=2;
//nums1[2]=3>nums2[2]=6 false
//nums1[5]=6   nums1={1,2,3,0,0,6}
//k=4; j=1; i=2;
//nums1[2]=3>nums2[1]=5 false
//nums1[4]=nums2[1]=5 nums1={1,2,3,0,5,6}
//k=3; j=0;
//nums1[2]=3>nums2[0] true
//nums1[3]=nums1[2]=3  nums1={1,2,3,3,5,6}
//k=2; i=1;
//nums1[1]=2>nums2[0]=2 false
//nums1[2]=nums2[0]=2 nums1={1,2,2,3,5,6}
//k=1;j=-1;