class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }
        String res = sb.substring(idx);
        return res.length()==0?"0":res;
    }
}