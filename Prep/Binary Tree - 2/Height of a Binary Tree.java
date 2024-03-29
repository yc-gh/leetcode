//https://leetcode.com/problems/maximum-depth-of-binary-tree/

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        return Integer.max(leftHeight, rightHeight) + 1;
    }
}
