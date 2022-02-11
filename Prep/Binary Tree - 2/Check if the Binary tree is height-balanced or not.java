//https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        return (isBalancedUtil(root) != -1);
    }
    
    private int isBalancedUtil(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = isBalancedUtil(root.left);
        if(leftHeight == -1) return -1;
        int rightHeight = isBalancedUtil(root.right);
        if(rightHeight == -1) return -1;
        
        boolean isBalanced = Math.abs(leftHeight - rightHeight) <= 1;
        return isBalanced ? (Integer.max(leftHeight, rightHeight) + 1) : -1;
    }
}
