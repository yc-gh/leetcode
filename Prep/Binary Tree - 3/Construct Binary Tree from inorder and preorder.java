//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class Solution {
    
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preIndex = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeUtil(preorder, inorder, map, 0, preorder.length-1);
    }
    
    private TreeNode buildTreeUtil(int[] preorder, int[] inorder, Map<Integer, Integer> map, 
                                  int start, int end) {
        
        if(preIndex >= preorder.length || start > end) return null;
        
        TreeNode curr = new TreeNode(preorder[preIndex++]);
        
        if(start == end) return curr;
        
        int index = map.get(curr.val);
        
        curr.left = buildTreeUtil(preorder, inorder, map, start, index-1);
        curr.right = buildTreeUtil(preorder, inorder, map, index+1, end);
        
        return curr;
    }
}
