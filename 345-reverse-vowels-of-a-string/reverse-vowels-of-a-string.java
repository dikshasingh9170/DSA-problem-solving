class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels=new StringBuilder();
        char[] s1=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(s1[i]=='a' || s1[i]=='e' || s1[i]=='i' || s1[i]=='o' || s1[i]=='u' || s1[i]=='A' || s1[i]=='E' || s1[i]=='I' || s1[i]=='O' || s1[i]=='U'){
                vowels.append(s.charAt(i));
            }
        }
        int n=vowels.length();
        int j=n-1;
        String v=vowels.toString();
        for(int i=0;i<s1.length;i++){
            if(s1[i]=='a' || s1[i]=='e' || s1[i]=='i' || s1[i]=='o' || s1[i]=='u' || s1[i]=='A' || s1[i]=='E' || s1[i]=='I' || s1[i]=='O' || s1[i]=='U'){
                s1[i]=v.charAt(j);
                j--;
            }
        }
        return new String(s1);
    }
}