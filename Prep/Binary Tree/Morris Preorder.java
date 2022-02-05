//https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {        
        List<Integer> ans = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode inorderPrev = curr.left;
                
                while(inorderPrev.right != null && inorderPrev.right != curr) {
                    inorderPrev = inorderPrev.right;
                }
                
                if(inorderPrev.right == null) {
                    ans.add(curr.val);
                    inorderPrev.right = curr;
                    curr = curr.left;
                }
                else {
                    inorderPrev.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }
}
