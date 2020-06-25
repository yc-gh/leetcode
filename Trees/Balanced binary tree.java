//https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root)!=-1;
    }
    
    private static int height(TreeNode root)
    {
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(left==-1 || right==-1) return -1;
        else if(Math.abs(left-right)>1) return -1;
        else return 1 + Integer.max(left,right);
    }
}
