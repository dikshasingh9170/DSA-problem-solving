class Solution {
   public static boolean isPalindrome(int x) {
        String s=Integer.toString(x);
        StringBuilder str2=new StringBuilder();
        str2.append(s);
        str2.reverse();
        String str1=str2.toString();
        if(s.equals(str1)){
            return true;
        }
        else{
            return false;
        }
    }
}