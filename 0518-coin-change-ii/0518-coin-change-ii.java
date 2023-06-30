class Solution {
    public int change(int amount, int[] coins) {
	    int N=coins.length;
	    int[][] t=new int[N+1][amount+1];
        for(int i=0;i<=N;i++){
            t[i][0]=1;
        }
        for(int i=1;i<=amount;i++){
            t[0][i]=0;
        }
        for(int i=1;i<=N;i++){
            for(int j=0;j<=amount;j++){
                if(coins[i-1]<=j){
                    t[i][j]=t[i][j-coins[i-1]]+t[i-1][j];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[N][amount];
	} 
}