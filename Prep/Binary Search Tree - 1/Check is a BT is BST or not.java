//https://leetcode.com/problems/validate-binary-search-tree/

class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }
    
    private boolean checkBST(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        if(min != null && root.val <= min) return false;
        else if(max != null && root.val >= max) return false;
        else {
            return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
        }
    }
}
