//https://practice.geeksforgeeks.org/problems/rod-cutting0840/1/

class Solution{
    public int cutRod(int price[], int n) {
        int[] memo = new int[n+1];
        
        return topDown(price, n, memo);
    }
    
    private int topDown(int[] price, int n, int[] memo) {
        if(n == 0) return 0;
        
        if(memo[n] > 0) return memo[n];
        
        int max = 0;
        for(int i=0; i<price.length; i++) {
            if((i+1) <= n) {
                max = Integer.max(topDown(price, n-(i+1), memo) + price[i], max);
            }
        }
        
        return memo[n] = max;
    }
}
