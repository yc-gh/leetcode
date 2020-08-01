//https://leetcode.com/problems/minimum-depth-of-binary-tree/

class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.left==null) return minDepth(root.right) + 1;
        else if(root.right==null) return minDepth(root.left) + 1;
        return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
