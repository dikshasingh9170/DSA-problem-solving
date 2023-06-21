class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==1){
            return heights[0];
        }
        Stack<Integer> st=new Stack<Integer>();
        int n=heights.length;
        int[] leftsmaller=new int[n];
        int[] rightsmaller=new int[n];
        for(int i=0;i<n;i++){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    leftsmaller[i]=st.peek();
                }
                else{
                    leftsmaller[i]=-1;
                }
                st.push(i);
        }
        st=new Stack<>();
        for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    rightsmaller[i]=st.peek();
                }
                else{
                    rightsmaller[i]=n;
                }
                st.push(i);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int curr=(rightsmaller[i]-leftsmaller[i]-1)*heights[i];
            max=Math.max(curr,max);
        }
        return max;
    }
}
