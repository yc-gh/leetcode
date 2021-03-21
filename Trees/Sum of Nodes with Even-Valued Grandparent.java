//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

class Solution {
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandparentUtil(root, null, null);
        return sum;
    }
    
    private void sumEvenGrandparentUtil(TreeNode root, TreeNode parent, TreeNode grandParent) {
        if(root == null) return;
        if(grandParent != null && (grandParent.val&1) == 0) sum += root.val;
        sumEvenGrandparentUtil(root.left, root, parent);
        sumEvenGrandparentUtil(root.right, root, parent);
    }
}
