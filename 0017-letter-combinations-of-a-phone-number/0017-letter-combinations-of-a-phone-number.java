class Solution {
    public List<String> letterCombinations(String digits) {
         List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        String output="";
        String options[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int n=Integer.parseInt(digits);
        int rev = 0; int rem;   
        while(n>0){
            rem = n%10;
            rev = (rev*10) + rem;
            n = n/10;
        }
        solve(rev,output,options,res);
        return res;
    }
    public void solve(int n,String output,String options[],List<String> res){
        if(n==0){
            res.add(output);
            return;
        }
        int n1=n%10;
        String s=options[n1];
        for(int i=0;i<s.length();i++){
            solve(n/10,output+s.charAt(i),options,res);
        }
    }
}