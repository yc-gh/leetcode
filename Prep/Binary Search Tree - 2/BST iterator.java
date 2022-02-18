//https://leetcode.com/problems/binary-search-tree-iterator/

class BSTIterator {
    
    Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushAllLeftChildren(root);
    }
    
    public int next() {
        TreeNode top = stack.pop();
        pushAllLeftChildren(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void pushAllLeftChildren(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
