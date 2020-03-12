// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// Single queue
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean evenLevel = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            while (levelSize-- > 0) {
                TreeNode curr = queue.poll();
                if (evenLevel)
                    levelList.add(curr.val);
                else
                    levelList.add(0, curr.val);
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            evenLevel = evenLevel ? false : true;

            result.add(levelList);
        }

        return result;
    }
}


// Two stacks
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        stack1.push(root);

        boolean evenLevel = true;

        while (stack1.size() > 0 || stack2.size() > 0) {
            List<Integer> levelList = new ArrayList<>();

            if (evenLevel) {
                int levelSize = stack1.size();
                while (levelSize-- > 0) {
                    TreeNode curr = stack1.pop();
                    levelList.add(curr.val);
                    if (curr.left != null)
                        stack2.push(curr.left);
                    if (curr.right != null)
                        stack2.push(curr.right);
                    evenLevel = false;
                }
            } else {
                int levelSize = stack2.size();
                while (levelSize-- > 0) {
                    TreeNode curr = stack2.pop();
                    levelList.add(curr.val);
                    if (curr.right != null)
                        stack1.push(curr.right);
                    if (curr.left != null)
                        stack1.push(curr.left);
                    evenLevel = true;
                }
            }

            result.add(levelList);
        }

        return result;
    }
}