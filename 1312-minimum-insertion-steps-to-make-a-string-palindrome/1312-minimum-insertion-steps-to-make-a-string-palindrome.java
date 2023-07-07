class Solution {
    public int minInsertions(String s) {
        String s2="";
        int m=s.length();
        for(int i=m-1;i>=0;i--){
            s2+=s.charAt(i);
        }
	    int n=s2.length();
	    int[][] t=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            t[i][0]=0;
        }
        for (int i=0;i<=n;i++){
            t[0][i]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                     t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return m-t[m][n];
    }
}