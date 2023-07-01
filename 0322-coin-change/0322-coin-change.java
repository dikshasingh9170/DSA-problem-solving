class Solution {
    public int coinChange(int[] coins, int amount) {
        int W=amount;
        int n=coins.length;
        int[][] t=new int[n+1][W+1];
        for(int i=0;i<=W;i++){
            t[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=n;i++){
            t[i][0]=0;
        }
        int j=1;
        for(int i=1;j<=W;j++){
            if(j%coins[i-1]==0){
                t[i][j]=j/coins[i-1];
            }
            else{
                t[i][j]=Integer.MAX_VALUE-1;
            }
        }
        for(int i=1;i<=n;i++){
            for( j=1;j<=W;j++){
                if(coins[i-1]<=j){
                    t[i][j]=Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }
                else if(coins[i-1]>j){
                    t[i][j]=t[i-1][j];
                }
            }
        }
        if(t[n][W]==Integer.MAX_VALUE-1){
            t[n][W]=-1;
        }
        return t[n][W];
    }
}