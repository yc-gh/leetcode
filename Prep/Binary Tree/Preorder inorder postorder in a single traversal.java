//https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution {
    
    class TreeNodeState {
        TreeNode node;
        Integer state;
        
        TreeNodeState(TreeNode n, Integer s) {
            this.node = n;
            this.state = s;
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        return allTraversals(root);
    }
    
    private List<Integer> allTraversals(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        
        if(root == null) return postorder;
        
        Deque<TreeNodeState> stack = new ArrayDeque<>();
        stack.push(new TreeNodeState(root, 1));
        
        while(!stack.isEmpty()) {
            TreeNodeState curr = stack.peek();
            if(curr.state == 1) {
                curr.state = 2;
                preorder.add(curr.node.val);
                if(curr.node.left != null) {
                    stack.push(new TreeNodeState(curr.node.left, 1));
                }
            }
            else if(curr.state == 2) {
                curr.state = 3;
                inorder.add(curr.node.val);
                if(curr.node.right != null) {
                    stack.push(new TreeNodeState(curr.node.right, 1));
                }
            }
            else {
                postorder.add(curr.node.val);
                stack.pop();
            }
        }
        
        return postorder;
    }
}
