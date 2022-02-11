//https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
    
    int diameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        
        height(root);
        return diameter;
    }
    
    private int height(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        diameter = Integer.max(diameter, leftHeight + rightHeight);
        return Integer.max(leftHeight, rightHeight) + 1;
    }
}
