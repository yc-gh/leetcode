// https://leetcode.com/problems/increasing-order-search-tree/

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
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode newRoot = null;
        TreeNode newCurr = null;
        while(!stack.isEmpty() || curr!=null)
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            
            if(newRoot==null)
            {
                newRoot = curr;
                newCurr = newRoot;
            }
            else
            {
                newCurr.right = curr;
                newCurr.left = null;
                newCurr = newCurr.right;
            }
            
            curr = curr.right;
        }
        
        return newRoot;
    }
}