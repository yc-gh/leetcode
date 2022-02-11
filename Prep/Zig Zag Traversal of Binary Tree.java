//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        boolean reverseOrder = false;
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            
            while(size --> 0) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            
            if(reverseOrder) Collections.reverse(currLevel);
            ans.add(currLevel);
            reverseOrder = !reverseOrder;
        }
        
        return ans;
    }
}
