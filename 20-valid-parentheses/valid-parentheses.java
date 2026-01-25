class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        char[] ch=s.toCharArray();
        for(char c:ch){
            if(!st.isEmpty()){
                char curr=st.peek();
                if(c==')' && curr=='(' || c==']' && curr=='[' || c=='}' && curr=='{'){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }
            else{
                if(c==')' || c==']' || c=='}'){
                    return false;
                }
                else{
                    st.push(c);
                }
            }
        }
        return st.isEmpty()?true:false;
    }
}