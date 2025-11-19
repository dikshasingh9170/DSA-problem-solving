/*class Solution {
    public int maxProfit(int[] prices) {
        return solve(0,prices,1,prices.length);
    }
    public int solve(int i,int[] prices,int buy,int n){
        if(i==n){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(i+1,prices,0,n),0+solve(i+1,prices,1,n));
        }
        else{
            profit=Math.max(prices[i]+solve(i+1,prices,1,n),0+solve(i+1,prices,0,n));
        }
        return profit;
    }
}*/
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}