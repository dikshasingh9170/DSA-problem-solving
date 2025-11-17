class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=prices[0];
        int max=0;
        for(int i=1;i<n;i++){
            max=Math.max(max,prices[i]-buy);
            if(buy>prices[i]){
                buy=prices[i];
            }
        }
        return max;
    }
}