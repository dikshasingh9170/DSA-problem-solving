class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        for(char c:ch){
            if(!st.isEmpty()){
                char curr=st.peek();
                if(c==')' && curr=='('){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else{
                {
                    st.push(c);
                }
            }
        }
        return st.size();
    }
}