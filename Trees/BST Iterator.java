//https://leetcode.com/problems/binary-search-tree-iterator/

class BSTIterator {

    Deque<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        addAll(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        addAll(top.right);
        return top.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void addAll(TreeNode root)
    {
        for(; root!=null; root=root.left) stack.push(root);
    }
}
