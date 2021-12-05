//https://leetcode.com/problems/path-sum-ii/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        
        if(root == null) return resList;
        
        pathSumUtil(root, targetSum, 0, new ArrayList<>(), resList);
        
        return resList;
    }
    
    private void pathSumUtil(TreeNode root, int targetSum, int currSum, List<Integer> path, List<List<Integer>> resList) {
        if(root == null) return;
        
        int currVal = root.val;
        
        path.add(currVal);
        
        currSum += currVal;
        
        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                resList.add(new ArrayList<>(path));
            }
        }
        
        if(root.left != null) pathSumUtil(root.left, targetSum, currSum, path, resList);
        if(root.right != null) pathSumUtil(root.right, targetSum, currSum, path, resList);
        
        path.remove(path.size()-1);
    }
}
