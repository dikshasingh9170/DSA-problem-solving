class Solution {
    public String reverseVowels(String s) {
        StringBuilder vowels=new StringBuilder();
        char[] s1=s.toCharArray();
        int l=0;int r=s1.length-1;
        while(l<r){
            while(l<r && !isVowel(s1[l]))l++;
            while(l<r && !isVowel(s1[r]))r--;
            char temp=s1[l];
            s1[l]=s1[r];
            s1[r]=temp;
            l++;
            r--;
        }
        return new String(s1);
    }
    public boolean isVowel(char s1){
        if(s1=='a' || s1=='e' || s1=='i' || s1=='o' || s1=='u' || s1=='A' || s1=='E' || s1=='I' || s1=='O' || s1=='U'){
                return true;
        }
        return false;
    }
}