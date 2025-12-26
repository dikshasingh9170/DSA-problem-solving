class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();String max="";
        for(int i=0;i<n;i++){
            String odd=expandFromCenter(i,i,n,s);
            String even=expandFromCenter(i,i+1,n,s);
            if(odd.length()>max.length()){
                max=odd;
            }
            if(even.length()>max.length()){
                max=even;
            }

        }
        return max;
    }
    public String expandFromCenter(int i,int j,int n,String s){
                String res="";

        while(i>=0 && j<n){
            if(s.charAt(i)!=s.charAt(j)){
                return res;
            }
            else{
                res=s.substring(i,j+1);
            }
            i--;
            j++;
        }
        return res;
    }
}