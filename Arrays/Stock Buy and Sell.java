// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        
        int maxprofit = 0;
        int minSoFar = prices[0];
        
        for(int i=0; i<prices.length; i++)
        {
            if(prices[i] > minSoFar)
            {
                maxprofit = Integer.max(maxprofit, prices[i]-minSoFar);
            }
            else
            {
                minSoFar = prices[i];
            }
        }
        
        return maxprofit;
    }
}