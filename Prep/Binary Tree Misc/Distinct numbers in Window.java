//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1/#

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if(A == null || A.length == 0) return ans;
        
        int i=0, j=0;
        
        while(j < n && j < k) {
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            j++;
        }
        
        ans.add(map.size());
        
        while(j < n) {
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            j++;
            
            map.put(A[i], map.getOrDefault(A[i], 0) - 1);
            if(map.get(A[i]) == 0) map.remove(A[i]);
            i++;
            
            ans.add(map.size());
        }
        
        return ans;
    }
}
