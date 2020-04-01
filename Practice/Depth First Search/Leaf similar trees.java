// https://leetcode.com/problems/leaf-similar-trees/

// Stack approach
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> leafs = new ArrayList<>();
        
        TreeNode curr = root1;
        
        while(!stack.isEmpty() || curr!=null)
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            
            curr = stack.pop();
            
            if(curr.left==null && curr.right==null) leafs.add(curr.val);
            
            curr = curr.right;
        }
        
        curr = root2;
        int listIndex = 0;
        
        while(!stack.isEmpty() || curr!=null)
        {
            while(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            
            curr = stack.pop();
            if(curr.left==null && curr.right==null) 
            {
                if(listIndex >= leafs.size()) return false;
                if(leafs.get(listIndex++)!=curr.val) return false;
            }
            
            curr = curr.right;
        }
        
        return true;
    }
}

// Recursion
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
    static int index;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        
        List<Integer> leafs = new ArrayList<>();
        traverse(root1,leafs);
        index = 0;
        if(!check(root2,leafs)) return false;
        return true;
    }
    
    static void traverse(TreeNode root, List<Integer> leafs)
    {
        if(root==null) return;
        if(root.left==null && root.right==null) 
        {
            leafs.add(root.val);
            return;
        }
        traverse(root.left, leafs);
        traverse(root.right, leafs);
    }
    
    static boolean check(TreeNode root, List<Integer> leafs)
    {
        if(root==null) return true;
        if(root.left==null && root.right==null)
        {
            if(index>=leafs.size()) return false;
            if(leafs.get(index++)!=root.val) return false;
            return true;
        }
        if(!check(root.left,leafs)) return false;
        if(!check(root.right,leafs)) return false;
        return true;
    }
}
