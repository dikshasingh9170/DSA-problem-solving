class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st=new Stack<>();
        char[] ch=s.toCharArray();
        int j=-1;
        for(char c:ch){
            j++;
            if(!st.isEmpty()){
                int curr=st.peek();
                if(c==')' && s.charAt(curr)=='('){
                    st.pop();
                }
                else{
                    if(c==')' || c=='(')st.push(j);
                }
            }
            else{
                if(c==')' || c=='(')st.push(j);
            }
        }
        String res="";
        for(int i=s.length()-1;i>=0;i--){
            if(!st.isEmpty()){
                int idx=st.peek();
                if(i==idx){
                    st.pop();
                }
                else{
                    res+=s.charAt(i);
                }
            }
            else{
                res+=s.charAt(i);
            }
        }
        StringBuilder sb=new StringBuilder(res);
        sb.reverse();
        return sb.toString();
    }
}