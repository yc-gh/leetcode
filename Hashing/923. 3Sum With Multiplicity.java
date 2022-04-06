//https://leetcode.com/problems/3sum-with-multiplicity/

// class Solution {
//     public int threeSumMulti(int[] arr, int target) {
//         int count = 0, n = arr.length;
//         int mod = 1000000007;
//         Arrays.sort(arr);
        
//         for(int i=0; i<n; i++) {
//             int j = i+1, k = n-1;

//             while(j < k) {
//                 int sum = arr[i] + arr[j] + arr[k];
//                 if(sum == target) {
//                     if(arr[j] == arr[k]) {
//                         count = (count + (((k-j) * (k-j+1)) / 2) % mod) % mod;
//                         break;
//                     }
//                     else {
//                         int l = 1, r = 1;
//                         while(j < k && arr[j] == arr[j + 1]) {
//                             j++;
//                             l++;
//                         }
//                         while(j < k && arr[k] == arr[k - 1]) {
//                             k--;
//                             r++;
//                         }
//                         count += (l * r) % mod;
//                         j++;
//                         k--;
//                     }
//                 }
//                 else if(sum > target) {
//                     k--;
//                 }
//                 else {
//                     j++;
//                 }
//             }
//         }
        
//         return count;
//     }
// }

class Solution {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;
            
            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }
}
