//https://leetcode.com/problems/deepest-leaves-sum/

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // int[] sum = new int[1];
        // dfs(root, 0, new int[1], sum);
        // return sum[0];
        
        return bfs(root);
    }
    
    private int bfs(TreeNode root)
    {
        int res = 0, i;
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        
        while(!queue.isEmpty())
        {
            for(i=queue.size()-1, res=0; i>=0; i--)
            {
                TreeNode curr = queue.poll();
                res += curr.val;
                if(curr.left!=null) queue.offerLast(curr.left);
                if(curr.right!=null) queue.offerLast(curr.right);
            }
        }
        
        return res;
    }
    
    private void dfs(TreeNode root, int depth, int[] maxDepth, int[] sum)
    {
        if(root==null) return;
        
        if(root.left==null && root.right==null) 
        {
            if(depth < maxDepth[0]) return;
            else if(depth == maxDepth[0]) sum[0] += root.val;
            else
            {
                sum[0] = root.val;
                maxDepth[0] = depth;
            }
            return;
        }
        
        dfs(root.left, depth+1, maxDepth, sum);
        dfs(root.right, depth+1, maxDepth, sum);
    }
}
