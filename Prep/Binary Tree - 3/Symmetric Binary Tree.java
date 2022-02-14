//https://leetcode.com/problems/symmetric-tree/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return checkTree(root.left, root.right);
    }
    
    private boolean checkTree(TreeNode A, TreeNode B) {
        if(A == null && B == null) return true;
        else if(A == null || B == null) return false;
        else if(A.val != B.val) return false;
        
        return checkTree(A.left, B.right) && checkTree(A.right, B.left);
    }
  
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root.left);
//         stack.push(root.right);
//         while (!stack.empty()) {
//             TreeNode n1 = stack.pop(), n2 = stack.pop();
//             if (n1 == null && n2 == null) continue;
//             if (n1 == null || n2 == null || n1.val != n2.val) return false;
//             stack.push(n1.left);
//             stack.push(n2.right);
//             stack.push(n1.right);
//             stack.push(n2.left);
//         }
//         return true;
//     }
}
