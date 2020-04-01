// https://leetcode.com/problems/validate-binary-search-tree/

//Stack solution

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

// Recursive

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, null, null);
    }

    static boolean checkBST(TreeNode curr, Integer low, Integer high) {
        if (curr == null)
            return true;
        return ((low == null || curr.val > low) && (high == null || curr.val < high)
                && checkBST(curr.left, low, curr.val) && checkBST(curr.right, curr.val, high));
    }
}