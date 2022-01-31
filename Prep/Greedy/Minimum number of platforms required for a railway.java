//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1/#

class Solution
{
    static int findPlatform(int arr[], int dep[], int n)
    {
        if(n == 0) return 0;
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int platforms = 0, maxPlatforms = 0;
        
        int i = 0, j = 0;
        
        while(i < n && j < n) {
            if(arr[i] <= dep[j]) {
                platforms++;
                maxPlatforms = Integer.max(maxPlatforms, platforms);
                i++;
            }
            else {
                platforms--;
                j++;
            }
        }
        
        return maxPlatforms;
    }
    
}
