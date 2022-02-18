//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTargetUtil(root, k, new HashSet<>());
    }
    
    private static boolean findTargetUtil(TreeNode root, int k, Set<Integer> set)
    {
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return findTargetUtil(root.left, k, set) || findTargetUtil(root.right, k, set);
    }
}
