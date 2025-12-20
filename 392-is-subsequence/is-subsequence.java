class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n==0)return true;
        if(m==0)return false;
        int i=0;int j=0;
        while(i<m){
            if(t.charAt(i)==s.charAt(j)){
                j++;
            }
            i++;
            if(j==n){
                return true;
            }
        }
        return false;
    }
}