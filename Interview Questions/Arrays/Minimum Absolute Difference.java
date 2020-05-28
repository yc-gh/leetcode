//https://leetcode.com/problems/minimum-absolute-difference/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int mindiff = arr[1]-arr[0];
        int n = arr.length;
        for(int i=0; i<n-1; i++)
        {
            int diff = arr[i+1]-arr[i];
            if(diff == mindiff)
            {
                res.add(Arrays.asList(arr[i],arr[i+1]));
            }
            else if(diff < mindiff)
            {
                mindiff = diff;
                res.clear();
                res.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return res;
    }
}
