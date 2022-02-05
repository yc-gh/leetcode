//https://leetcode.com/problems/binary-tree-inorder-traversal/

//Morris inorder
//Link all inorder predecessors with successor (threaded binary tree)
//Effectively creating a right skewed tree
//Print node when left subtree doesn't exist
//Print node when an ancestor was reached
//2 phase traversal -- create threads / destroy threads

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {        
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
                    inorderPrev.right = curr;
                    curr = curr.left;
                }
                else {
                    ans.add(curr.val);
                    inorderPrev.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return ans;
    }
}
