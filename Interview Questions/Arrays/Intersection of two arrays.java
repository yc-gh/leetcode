//https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set<Integer> set = new HashSet<>();
        // int k=0,i=0,j=0;
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // while(i<nums1.length && j<nums2.length)
        // {
        //     if(nums1[i]<nums2[j]) i++;
        //     else if(nums1[i]>nums2[j]) j++;
        //     else
        //     {
        //         set.add(nums1[i]);
        //         i++;
        //         j++;
        //     }
        // }
        // int[] res = new int[set.size()];
        // for(Integer ele : set) res[k++] = ele;
        // return res;
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        for(int i : nums1) set1.add(i);
        for(int i : nums2) if(set1.contains(i)) set2.add(i);
        
        int[] res = new int[set2.size()];
        int k = 0;
        for(int i : set2) res[k++] = i;
        return res;
    }
}
