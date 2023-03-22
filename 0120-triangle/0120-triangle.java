class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.size()];
        int i=triangle.size()-1;
        for(int j=0;j<i+1;j++){
            dp[i][j]=triangle.get(i).get(j);
        }
        for(i=triangle.size()-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                dp[i][j]=Math.min(triangle.get(i).get(j)+dp[i+1][j],triangle.get(i).get(j)+dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}