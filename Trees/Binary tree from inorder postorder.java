//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

class Solution {
    
    private int postIndex = -1;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        postIndex = n-1;
        return buildTreeUtil(inorder, postorder, 0, n-1);
    }
    
    private TreeNode buildTreeUtil(int[] inorder, int[] postorder, int inStart, int inEnd)
    {
        if(postIndex < 0) return null;
        else if(inStart <= inEnd)
        {
            int inIndex = searchInorder(inorder, inStart, inEnd, postorder[postIndex]);
            TreeNode root = new TreeNode(postorder[postIndex--]);
            root.right = buildTreeUtil(inorder, postorder, inIndex+1, inEnd);
            root.left = buildTreeUtil(inorder, postorder, inStart, inIndex-1);
            return root;
        }
        else return null;
    }
    
    private int searchInorder(int[] inorder, int start, int end, int key)
    {
        for(int i=0; i<inorder.length; i++)
        {
            if(inorder[i]==key) return i;
        }
        return -1;
    }
}

class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0) return null;
        Map<Integer,Integer> map = hashInorder(inorder);
        int n = postorder.length;
        int[] postIndex = new int[]{n-1};
        return buildTreeUtil(inorder, postorder, postIndex, 0, n-1, map);
    }
    
    private TreeNode buildTreeUtil(int[] inorder, int[] postorder, int[] postIndex, int inStart, int inEnd, Map<Integer,Integer> map)
    {
        if(postIndex[0] < 0) return null;
        else if(inStart <= inEnd)
        {
            int inIndex = searchInorder(map, postorder[postIndex[0]]);
            TreeNode root = new TreeNode(postorder[postIndex[0]--]);
            root.right = buildTreeUtil(inorder, postorder, postIndex, inIndex+1, inEnd, map);
            root.left = buildTreeUtil(inorder, postorder, postIndex, inStart, inIndex-1, map);
            return root;
        }
        else return null;
    }
    
    private Map<Integer,Integer> hashInorder(int[] inorder)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return map;
    }
    
    private int searchInorder(Map<Integer,Integer> map, int key)
    {
        return map.get(key);
    }
}
