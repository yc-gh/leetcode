//https://leetcode.com/problems/path-sum/

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return checkPathSum(root, sum, 0);
    }
    
    private boolean checkPathSum(TreeNode root, int sum, int currsum)
    {
        if(root==null) return false;
        
        currsum += root.val;
        
        if(root.left==null && root.right==null)
        {
            if(currsum == sum) return true;
            else return false;
        }
        return checkPathSum(root.left, sum, currsum) || checkPathSum(root.right, sum, currsum);
    }
}
