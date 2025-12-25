class Solution {
    public String reverseWords(String s) {
        String[] str=s.trim().split("\\s+");
        StringBuilder out =new StringBuilder();

        int l=0;int r=str.length-1;
        while(l<r){
            String temp=str[l];
            str[l]=str[r];
            str[r]=temp;
            l++;
            r--;
        }

        return new String(String.join(" ",str));
    }
}
