//https://leetcode.com/problems/cousins-in-binary-tree/

class Solution {
    int h;
    TreeNode p;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        h = -1;
        p = null;
        return isCousinsUtil(root.left, x, y, 1, root) || 
            isCousinsUtil(root.right, x, y, 1, root);
    }
    
    private boolean isCousinsUtil(TreeNode root, int x, int y, int height, TreeNode parent) {
        if(root == null) return false;
        if(root.val == x || root.val == y)
        {
            if(h != -1)
            {
                if(height == h)
                {
                    if(parent != p) return true;
                }
            }
            else
            {
                h = height;
                p = parent;
            }
        }
        return isCousinsUtil(root.left, x, y, height+1, root) || 
                isCousinsUtil(root.right, x, y, height+1, root);
    }
}
