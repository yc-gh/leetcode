// https://leetcode.com/problems/binary-tree-maximum-path-sum/

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
    static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        getPathSum(root);
        return maxSum;
    }
    
    static int getPathSum(TreeNode root)
    {
        if(root==null) return 0;
        int leftPathSum = Integer.max(0, getPathSum(root.left));
        int rightPathSum = Integer.max(0, getPathSum(root.right));
        maxSum = Integer.max(maxSum, leftPathSum+rightPathSum+root.val);
        return Integer.max(leftPathSum,rightPathSum) + root.val;
    }
}