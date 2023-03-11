class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];int max=0,profit=0;
        for(int i=0;i<prices.length;i++){
            profit=Math.max(profit,prices[i]-min);
            if(prices[i]<min){
                min=prices[i];
            }
        }
        return profit;
    }
}