//https://leetcode.com/problems/binary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            
            int queueSize = queue.size();
            
            for(int i=0; i<queueSize; i++) {
                TreeNode first = queue.poll();
                temp.add(first.val);
                
                if(first.left != null) queue.offer(first.left);
                if(first.right !=  null) queue.offer(first.right);
            }
            
            result.add(temp);
        }
        
        return result;
    }
}
