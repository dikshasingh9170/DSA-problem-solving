class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums2.length];
        for(int i=0;i<res.length;i++)res[i]=-1;
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(nums2[i]);
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],res[i]);
        }
        int[] ans=new int[nums1.length];int idx=0;
        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}