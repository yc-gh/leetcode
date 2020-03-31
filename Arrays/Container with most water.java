// https://leetcode.com/problems/container-with-most-water/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int i=0, j=n-1;
        while(i<j)
        {
            int area = (j-i) * Integer.min(height[i],height[j]);
            if(area>maxArea) maxArea = area;
            if(height[i]<height[j]) i++;
            else j--;
        }
        return maxArea;
    }
}