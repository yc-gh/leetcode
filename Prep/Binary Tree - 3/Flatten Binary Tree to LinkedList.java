//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

class Solution {
//     public void flatten(TreeNode root) {
//         flattenUtil(root);
//     }
    
//     private TreeNode flattenUtil(TreeNode root) {
//         if(root == null) return null;
        
//         TreeNode left = root.left, right = root.right;
//         TreeNode leftLast = flattenUtil(root.left);
//         TreeNode rightLast = flattenUtil(root.right);
        
//         if(leftLast == null && rightLast == null) return root;
//         else if(leftLast == null) return rightLast;
//         else if(rightLast == null) {
//             root.left = null;
//             root.right = left;
//             return leftLast;
//         }
//         else {
//             root.left = null;
//             root.right = left;
//             leftLast.right = right;

//             return rightLast;
//         }
//     }
  
    TreeNode prev; // Use postorder traversal to store root of flattened right subtree
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
