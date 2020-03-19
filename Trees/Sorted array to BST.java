// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length-1);
    }
    
    TreeNode getBST(int[] arr, int l, int r)
    {
        if(l>r)
        {
            return null;
        }
        int mid = l + (r-l)/2;
        TreeNode rootcurr = new TreeNode(arr[mid]);
        rootcurr.right = getBST(arr, mid+1, r);
        rootcurr.left = getBST(arr, l, mid-1);
        return rootcurr;
    }
}