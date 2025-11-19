class Solution {
    public int minMovesToMakePalindrome(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder(s);
        int ans=0;
        while(sb.length()>1){
           char ch=sb.charAt(0);
           int pos= sb.lastIndexOf(ch+"");
           if(pos==0){
            ans+=n/2;
           }
           else{
            ans+=n-pos-1;
            sb.deleteCharAt(pos);
            n--;
           }
           sb.deleteCharAt(0);
           n--;
        }
        
        return ans;
    }
}