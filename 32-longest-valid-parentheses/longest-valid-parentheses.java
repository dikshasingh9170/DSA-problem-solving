class Solution {
    public int longestValidParentheses(String s) {
        Stack<Pair> st=new Stack<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty()){
                Pair curr=st.peek();
                char currCh=curr.ch;
                int idx=curr.idx;
                if(s.charAt(i)==')' && currCh=='('){
                    st.pop();
                }
                else{
                    st.push(new Pair(s.charAt(i),i));
                }
            }
            else{
                st.push(new Pair(s.charAt(i),i));
            }
        }
        int len=s.length();
        if(st.isEmpty()){
            return len;
        }
        while(!st.isEmpty()){
            Pair curr=st.pop();
            int idx=curr.idx;
            max=Math.max(max,len-idx-1);
            len=idx;
        }
        max=Math.max(max,len);
        return max;
    }
}
class Pair{
    char ch;
    int idx;
    public Pair(char ch,int idx){
        this.ch=ch;
        this.idx=idx;
    }
}