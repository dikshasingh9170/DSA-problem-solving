class Solution {
    public String reverseStr(String s, int k) {
        int n=s.length();
        char[] s1=s.toCharArray();
        for(int i=0;i<s.length();i+=2*k){
            int l=i;
            int r=Math.min(l+k-1,n-1);
            while(l<r){
                char temp=s1[l];
                s1[l]=s1[r];
                s1[r]=temp;
                l++;
                r--;
            }
        }
        return new String(s1);
    }
}