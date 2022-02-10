//https://leetcode.com/problems/maximum-width-of-binary-tree/

class Solution {
    
    class UtilNode {
        TreeNode node;
        Integer pos;
        
        UtilNode(TreeNode n, Integer p) {
            this.node = n;
            this.pos = p;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        
        Deque<UtilNode> queue = new ArrayDeque<>();
        
        queue.offer(new UtilNode(root, 1));
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int start = queue.peekFirst().pos;
            int end = queue.peekLast().pos;
            
            maxWidth = Math.max(maxWidth, Math.abs(end-start) + 1);
            
            while(size --> 0) {
                UtilNode curr = queue.poll();
                TreeNode node = curr.node;
                Integer pos = curr.pos;
                
                if(node.left != null) queue.offer(new UtilNode(node.left, pos*2));
                if(node.right != null) queue.offer(new UtilNode(node.right, pos*2 + 1));
            }
            
        }
        
        return maxWidth;
    }
}
