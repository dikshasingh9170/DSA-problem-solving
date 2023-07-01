class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] t=new int[text1.length()+1][text2.length()+1];
        for (int[] row : t)
            Arrays.fill(row,-1);
        return lcs(text1,text2,text1.length(),text2.length(),t);
    }
    public int lcs(String text1,String text2,int n,int m,int[][] t){
        if(n==0 || m==0){
            return 0;
        }
        if(t[n][m]!=-1){
            return t[n][m];
        }
        if(text1.charAt(n-1)==text2.charAt(m-1)){
            t[n][m]=1+lcs(text1,text2,n-1,m-1,t);
        }
        else{
            t[n][m]=Math.max(lcs(text1,text2,n-1,m,t),lcs(text1,text2,n,m-1,t));
        }
        return t[n][m];
    }
}