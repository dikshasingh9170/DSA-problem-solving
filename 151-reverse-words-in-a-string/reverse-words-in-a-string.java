class Solution {
    public String reverseWords(String s) {
        String[] str=s.trim().split(" ");
        StringBuilder out =new StringBuilder();

        for (int i = str.length - 1; i >=0; i--) {
            if(!str[i].equals("")){
                out.append(str[i]+" ");

            }
        }

        return out.toString().trim();
    }
}
