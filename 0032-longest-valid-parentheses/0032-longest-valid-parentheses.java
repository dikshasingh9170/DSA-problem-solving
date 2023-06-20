class Solution {
    public int longestValidParentheses(String s) {
        /*Stack<Character> st=new Stack<Character>();
        if(s.length()==0){
            return 0;
        }
        int curr=0;int length=0;int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(s.charAt(i));curr++;
                ans=length;
                length=0;
            }
            else{
                x=st.pop();
                if(x=='(' && s.charAt(i)==')'){
                    length+=2;
                    curr--;
                    if(curr==0){
                        ans=length+max;
                    }
                    else{
                        ans=Math.max(ans,max);
                    }
                }
            }
        }*/
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(ch=='(')
                st.push(i);
            else
                if( !st.isEmpty() && s.charAt(st.peek())=='(' )
                    st.pop();
                else
                    st.push(i);
        }
        
        int max = 0;
        int n = s.length();
        while(!st.isEmpty())
        {
            int i = st.pop();
            max = Math.max(max,n-i-1);
            n = i;
        }
        return Math.max(max,n);
    }
}