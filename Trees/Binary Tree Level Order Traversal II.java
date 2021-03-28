//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        while(queue.size() > 0)
        {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while(size-->0)
            {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            
            res.add(0, temp);
        }
        
        return res;
    }
}
