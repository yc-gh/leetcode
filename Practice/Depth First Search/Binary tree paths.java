// https://leetcode.com/problems/binary-tree-paths/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root!=null) getPaths(root, new StringBuilder(), list);
        return list;
    }
    
    static void getPaths(TreeNode root, StringBuilder sb, List<String> list)
    {
        if(root==null) return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left==null && root.right==null) 
        {
            list.add(sb.toString());
        }
        else
        {
            sb.append("->");
            getPaths(root.left, sb, list);
            getPaths(root.right, sb, list);
        }
        sb.setLength(len);
    }
}