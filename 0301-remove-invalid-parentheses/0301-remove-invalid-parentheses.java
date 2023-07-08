class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        HashSet<String> hs=new HashSet<String>();
        int min=removebracket(s);
        solve(min,s,res,hs);
        return res;
    }
    public void solve(int min,String s,List<String> res,HashSet<String> set){
        if(set.contains(s))return;
        set.add(s);
        if(min==0){
            int remove=removebracket(s);
            if(remove==0){
                res.add(s);
            }
            return;
        }
        for(int i=0;i<s.length();i++){
            String l=s.substring(0,i);
            String r=s.substring(i+1);
            if(!set.contains(l+r)){
                solve(min-1,l+r,res,set);
            }
        }
    }
    public int removebracket(String s){
        Stack<Character> st=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(x=='('){
                st.push(x);
            }
            else if(x==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
                else{
                    st.push(x);
                }
            }
        }
        return st.size();
    }
}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       