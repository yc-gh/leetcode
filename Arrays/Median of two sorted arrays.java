// https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int count;
        int m1 = -1, m2 = -1;
        int m = nums1.length;
        int n = nums2.length;
        
        //If m+n is odd, median is m+n/2 with 0 indexing
        if((m+n)%2 == 1)
        {
           for(count=0; count<=(m+n)/2; count++)
           {
               if(i<m && j<n)
               {
                   m1 = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
               }
               else if(i<m)
               {
                   m1 = nums1[i++];
               }
               else 
               {
                   m1 = nums2[j++];
               }
           }
           return m1;
        }
        
        //Else m+n is even and median is average of m+n/2 and (m+n/2)-1th terms
        else
        {
            for(count=0; count<=(m+n)/2; count++)
            {
                //Fetch the last value of m1 
                //So that we have the last and second last terms from the loop
                m2 = m1;
                if(i<m && j<n)
                {
                    m1 = (nums1[i] > nums2[j]) ? nums2[j++] : nums1[i++];
                }
                else if(i<m)
                {
                    m1 = nums1[i++];
                }
                else 
                {
                    m1 = nums2[j++];
                }
            }
            return (double)(m1+m2)/2;
        }
    }
}