class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        if(s.length()==0){
            return true;
        }
        st.push(s.charAt(0));char x=0;int flag=0;
        for(int i=1;i<s.length();i++){
            if(!st.isEmpty()){
                x=st.pop();
                if(s.charAt(i)==')' && x=='('){
                    continue;
                }
                else if(s.charAt(i)=='}' && x=='{'){
                    continue;
                }
                else if(s.charAt(i)==']' && x=='['){
                    continue;
                }
                else if(s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}'){
                    return false;
                }
                st.push(x);
                st.push(s.charAt(i));
                x=0;
            }
            else{
                st.push(s.charAt(i));
            }
        }
            if(st.size()==0){
            return true;
            }
        return false;
    }
}