//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        int n = prices.length;
        
        for(int i=0; i<n; i++) {
            int currPrice = prices[i];
            if(currPrice > buyPrice) {
                profit = Integer.max(profit, currPrice - buyPrice);
            }
            else {
                buyPrice = currPrice;
            }
        }
        
        return profit;
    }
}
