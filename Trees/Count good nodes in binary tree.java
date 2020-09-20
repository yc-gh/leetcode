//https://leetcode.com/problems/count-good-nodes-in-binary-tree/

class Solution {
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
    
    private int countGoodNodes(TreeNode root, int max)
    {
        if(root==null) return 0;
        
        int newMax = Integer.max(max, root.val);
        
        return (root.val >= max ? 1 : 0) + countGoodNodes(root.left, newMax) + countGoodNodes(root.right, newMax);
    }
}
