// https://leetcode.com/problems/intersection-of-two-arrays-ii/

// Hashing
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> hashmap = new HashMap<>();
        
        int resultlength = (nums1.length<nums2.length)?nums1.length:nums2.length;
        int[] result = new int[resultlength];
        int index=0;
        
        for(int num : nums1)
        {
            hashmap.put(num, hashmap.getOrDefault(num,0)+1);
        }
        for(int num : nums2)
        {
            if(hashmap.containsKey(num) && hashmap.get(num)>0)
            {
                result[index++] = num;
                hashmap.put(num, hashmap.get(num)-1);
            }
        }
        
        
        return Arrays.copyOfRange(result, 0, index);
    }
}

// Sorting
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] intersection = new int[Math.min(nums1Length, nums2Length)];
        int nums1Index = 0;
        int nums2Index = 0;
        int intersectionIndex = 0;
        while (nums1Index < nums1Length && nums2Index < nums2Length) {
            if (nums1[nums1Index] == nums2[nums2Index]) {
                intersection[intersectionIndex] = nums1[nums1Index];
                nums1Index++;
                nums2Index++;
                intersectionIndex++;
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                nums1Index++;
            } else {
                nums2Index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, intersectionIndex);
    }
}