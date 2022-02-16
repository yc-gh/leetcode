//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

class Solution {
    
    int preIndex = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode constructBST(int[] preorder, int minBound, int maxBound) {
        if( preIndex == preorder.length || 
            preorder[preIndex] <= minBound || 
            preorder[preIndex] >= maxBound  ) {
            return null;
        }
        
        TreeNode curr = new TreeNode(preorder[preIndex++]);
        
        curr.left = constructBST(preorder, minBound, curr.val);
        curr.right = constructBST(preorder, curr.val, maxBound);
        
        return curr;
    }
}
