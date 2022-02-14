//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution {
    
    int postIndex = 0;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length-1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeUtil(postorder, map, 0, postorder.length-1);
    }
    
    private TreeNode buildTreeUtil(int[] postorder, Map<Integer, Integer> map, 
                                  int start, int end) {
        
        if(postIndex < 0 || start > end) return null;
        
        TreeNode curr = new TreeNode(postorder[postIndex--]);
        
        if(start == end) return curr;
        
        int index = map.get(curr.val);
        
        curr.right = buildTreeUtil(postorder, map, index+1, end);
        curr.left = buildTreeUtil(postorder, map, start, index-1);
        
        return curr;
    }
}
