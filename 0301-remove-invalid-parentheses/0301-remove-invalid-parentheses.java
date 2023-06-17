class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res=new ArrayList<>();
        HashSet<String> hs=new HashSet<String>();
        int min=removebracket(s);
        System.out.println(min);
        solve(min,s,res,hs);
        return res;
    }
    public void solve(int min,String s,List<String> res,HashSet<String> hs){
        if(hs.contains(s))return;
        
        hs.add(s);
        
        if(min==0){
            int remove=removebracket(s);   
            if(remove==0) res.add(s);
            return;
        }
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='(' && s.charAt(i)!=')')continue;
            String L=s.substring(0,i);
            String R=s.substring(i+1);
            if(!hs.contains(L+R)){
                System.out.println(L+R+" "+min);
                solve(min-1,L+R,res,hs);
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

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       