// https://leetcode.com/problems/count-primes/

// Sieve of eratosthenes
class Solution {
    public int countPrimes(int n) {
        if(n==0) return 0;
        
        int count = 0;
        
        boolean[] mark = new boolean[n];
        
        for(int i=2; i*i<=n-1; i++)
        {
            if(mark[i]==false)
            {
                for(int j=i*i; j<=n-1; j+=i)
                {
                    mark[j] = true;
                }
            }
        }
        
        for(int i=2; i<n; i++)
        {
            if(mark[i]==false) count++;
        }
        
        return count;
    } 
}

//Simple multiples solution
