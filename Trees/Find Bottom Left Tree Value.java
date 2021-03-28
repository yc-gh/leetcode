//https://leetcode.com/problems/find-bottom-left-tree-value/

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();        
        queue.offer(root);
        while(queue.size() > 0)
        {
            root = queue.poll();
            if(root.right != null) queue.offer(root.right);
            if(root.left != null) queue.offer(root.left);
        }
        
        return root.val;
    }
}
