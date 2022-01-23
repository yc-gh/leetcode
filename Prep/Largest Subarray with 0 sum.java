//Not found in LC - Check again

class Solution
{
    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, sum = 0;
        
        for(int i=0; i<n; i++) {
            sum += arr[i];
            
            if(sum == 0) maxLen = i + 1;
            
            if(map.containsKey(sum)) {
                maxLen = Integer.max(maxLen, i - map.get(sum));
            }
            else {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
