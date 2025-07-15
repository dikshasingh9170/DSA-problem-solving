class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ds=new ArrayList<>();
        helper(0,s,ds,ans);
        return ans;
    }
    public void helper(int index,String s,List<String> ds,List<List<String>> ans){
        if(s.isEmpty()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<s.length();i++){
            String curr=s.substring(0,i+1);
            if(isPalindrome(curr)){
                ds.add(curr);
                helper(index+1,s.substring(i+1),ds,ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s){
        int l=0;int r=s.length()-1;
        while(l<=r){
            if(s.charAt(l++)!=s.charAt(r--))return false;
        }
        return true;
    }
}
   