//https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        height(root,max);
        return max[0];
    }
    
    private static int height(TreeNode root, int[] max)
    {
        if(root==null) return 0;
        int left = height(root.left,max);
        int right = height(root.right,max);
        int through = left+right;
        max[0] = Integer.max(max[0], through);
        return left > right ? left+1 : right+1;
    }
}
