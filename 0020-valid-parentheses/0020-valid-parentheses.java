class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                st.push(s.charAt(i));
            }else{
                if(!st.isEmpty()){
                    char x=st.peek();
                    if(x=='(' && s.charAt(i)==')' || x=='{' && s.charAt(i)=='}' || x=='[' && s.charAt(i)==']'){
                        st.pop();
                    }
                    else{
                        st.push(s.charAt(i));
                    }
                }
                else{
                    st.push(s.charAt(i));
                }
                
            }
        }
        return st.isEmpty()?true:false;
    }
}