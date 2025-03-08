class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<Character>();
        Queue<Character> q=new LinkedList<Character>();
        String res="";
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
                q.offer(s.charAt(i));
            }else{
                char c=st.peek();
                if(c=='(' && s.charAt(i)==')'){
                    st.pop();
                    if(st.isEmpty()){
                        q.poll();
                        while(!q.isEmpty()){
                            res+=q.poll();
                        }
                    }else{
                        q.offer(s.charAt(i));
                    }
                }
                else if(c==')' && s.charAt(i)==')'){
                    st.push(s.charAt(i));
                    q.offer(s.charAt(i));
                }
                else if(s.charAt(i)=='('){
                    st.push(s.charAt(i));
                    q.offer(s.charAt(i));
                }
            }
        }
        return res;
    }
}