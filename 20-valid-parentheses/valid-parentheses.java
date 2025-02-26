class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty() && (c==']' || c=='}' || c==')')){
                return false;
            }else if(!st.isEmpty()){
                char c2=st.peek();
                if((c2=='{' && c=='}')|| (c2=='['&& c==']') || (c2=='(' && c==')')){
                    st.pop();
                }
                else{
                    st.push(c);
                }
            }else{
                st.push(c);
            }
        }
        return st.isEmpty()?true:false;
    }
}