// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return Integer.MIN_VALUE;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (--k == 0)
                return curr.val;
            curr = curr.right;
        }

        return Integer.MIN_VALUE;
    }
}

