//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

//class Solution {
//    public boolean findTarget(TreeNode root, int k) {
//        return findTargetUtil(root, k, new HashSet<>());
//    }
//    
//    private static boolean findTargetUtil(TreeNode root, int k, Set<Integer> set)
//    {
//        if(root==null) return false;
//        if(set.contains(k-root.val)) return true;
//        set.add(root.val);
//        return findTargetUtil(root.left, k, set) || findTargetUtil(root.right, k, set);
//    }
//}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        // save path to smallest node
        Stack<TreeNode> stackL = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stackL.push(p);
            p = p.left;
        }
        
        // save path to greatest node
        Stack<TreeNode> stackR = new Stack<>();
        p = root;
        while (p != null) {
            stackR.push(p);
            p = p.right;
        }

        // the idea of two pointers: left pointer and right pointer will never meet/cross.
        while (stackL.peek() != stackR.peek()) 
        {
            int sum = stackL.peek().val + stackR.peek().val;
            if (sum == k) 
            {
                return true;
            } 
            else if (sum < k) 
            {
                // get next greater
                TreeNode node = stackL.pop().right;
                while (node != null) 
                {
                    stackL.push(node);
                    node = node.left;
                }
            } 
            else 
            {
                // get next smaller
                TreeNode node = stackR.pop().left;
                while (node != null) 
                {
                    stackR.push(node);
                    node = node.right;
                }
            }
        }
        return false;
    }
}
