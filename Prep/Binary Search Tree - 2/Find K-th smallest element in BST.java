//https://leetcode.com/problems/kth-smallest-element-in-a-bst/

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        return util(root, new int[]{k});
    }
    
    private int util(TreeNode root, int[] k) {
        if(root == null) return -1;
        
        int left = util(root.left, k);
        if(left != -1) return left;
        if(--k[0] == 0) return root.val;
        return util(root.right, k);
    }
}
