class Solution {
    public String reverseWords(String s) {
        String[] str=s.trim().split(" ");
        String out = "";

        for (int i = str.length - 1; i >=0; i--) {
            if(str[i]!=""){
                out += str[i] + " ";
            }
        }

        return out.trim();
    }
}