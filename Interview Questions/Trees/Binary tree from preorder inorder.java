// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //Optimised searching using hashmap
class Solution {
    static int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) return null;
        preIndex = 0;
        Map<Integer,Integer> hashmap = new HashMap<>();
        for(int i=0; i<inorder.length; i++)
        {
            hashmap.put(inorder[i],i);
        }
        return buildTreeUtil(preorder, hashmap, 0, inorder.length-1);
    }
    
    static TreeNode buildTreeUtil(int[] preorder, Map<Integer,Integer> hashmap, int start, int end)
    {
        if(preIndex >= preorder.length || start>end) return null;
        TreeNode curr = new TreeNode(preorder[preIndex++]);
        
        if(start==end) return curr;
        
        int inoIndex = hashmap.get(curr.val);
        
        curr.left = buildTreeUtil(preorder,hashmap,start,inoIndex-1);
        curr.right = buildTreeUtil(preorder,hashmap,inoIndex+1,end);
        
        return curr;
    }
}