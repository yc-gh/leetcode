//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BSTUtil(nums, 0, nums.length-1);
    }
    
    private TreeNode BSTUtil(int[] nums, int l, int r) {
        if(l <= r) {
            int mid = l + (r-l)/2;
            TreeNode curr = new TreeNode(nums[mid]);
            curr.left = BSTUtil(nums, l, mid-1);
            curr.right = BSTUtil(nums, mid+1, r);
            return curr;
        }
        return null;
    }
}
