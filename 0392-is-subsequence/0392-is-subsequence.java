class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] t1=new int[n+1][m+1];
        for (int i=0;i<=n;i++){
            t1[i][0]=0;
        }
        for (int i=0;i<=m;i++){
            t1[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                     t1[i][j]=1+t1[i-1][j-1];
                }
                else{
                    t1[i][j]=Math.max(t1[i-1][j],t1[i][j-1]);
                }
            }
        }
        return t1[n][m]==n;
    }
}
