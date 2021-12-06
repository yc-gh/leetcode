//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution {
//     public void flatten(TreeNode root) {
//         if(root == null) return;
        
//         flatten(root.left);
//         flatten(root.right);
        
//         TreeNode rightmostOfLeftSubtree = getRightmostNode(root.left);
        
//         if(rightmostOfLeftSubtree != null) {
//             rightmostOfLeftSubtree.right = root.right;
//             root.right = root.left;
//             root.left = null;
//         }
//     }
    
//     private TreeNode getRightmostNode(TreeNode root) {
//         while(root != null && root.right != null) {
//             root = root.right;
//         }
        
//         return root;
//     }
    
    TreeNode prev;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
