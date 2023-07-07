class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
	    int n=word2.length();
	    int[][] t=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            t[i][0]=0;
        }
        for (int i=0;i<=n;i++){
            t[0][i]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                     t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return (m-t[m][n])+(n-t[m][n]);
    }
}
