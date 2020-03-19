// https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        
        return checkTree(root.left, root.right);
    }
    
    boolean checkTree(TreeNode a, TreeNode b)
    {
        if(a==null && b==null) return true;
        
        if(a==null || b==null) return false;
        
        if(a.val!=b.val) return false;
        
        return checkTree(a.left,b.right) && checkTree(a.right,b.left);
    }
}