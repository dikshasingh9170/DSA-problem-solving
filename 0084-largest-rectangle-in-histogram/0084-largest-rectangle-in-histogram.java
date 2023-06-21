/*class Solution {
    public int largestRectangleArea(int[] heights) {
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
        for(int i=n-1;i>=0;i--){
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    rightsmaller[i]=st.peek();
                }
                else{
                    rightsmaller[i]=-1;
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
}*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int smallleft[] = new int[n];
        int smallright[] = new int[n];
        Stack<Integer> s = new Stack<>();

        //small left index
        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                smallleft[i] = -1;
            }
            else{
                smallleft[i] = s.peek();
            }

            s.push(i);
        }

        //small right index
        s = new Stack<>();
        for(int i=heights.length-1; i>=0; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                smallright[i] = heights.length;
            }
            else{
                smallright[i] = s.peek();
            }

            s.push(i);
        }
        int largeRectangle = 0;
        for(int i=0; i<heights.length; i++){
            int height = heights[i];
            int width = smallright[i] -smallleft[i]-1;
            int currRectangle = height * width;
            largeRectangle = Math.max(currRectangle, largeRectangle);
        }

        return largeRectangle;


    }
}


