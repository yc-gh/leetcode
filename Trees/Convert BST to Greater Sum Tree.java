//https://leetcode.com/problems/convert-bst-to-greater-tree/

class Solution {
    int greater = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null) return null;
        bstToGst(root.right);
        root.val += greater;
        greater = root.val;
        bstToGst(root.left);
        return root;
    }
}
