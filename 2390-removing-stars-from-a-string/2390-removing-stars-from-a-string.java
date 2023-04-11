class Solution {
    public String removeStars(String s) {
       Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='*' && !st.isEmpty()){
                st.pop();
            }
            else if(s.charAt(i)=='*'){
                continue;
            }
            else{
                st.push(s.charAt(i));
            }
        }
        String x="";
        while(!st.isEmpty()){
            x+=st.pop();
        } 
        StringBuilder sb=new StringBuilder(x);
        sb.reverse();
        return sb.toString();
    }
}