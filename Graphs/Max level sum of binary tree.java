//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

class Solution {
    public int maxLevelSum(TreeNode root) {
        return levelOrderBFS(root);
        // return preorderDFS(root);
    }
    
    private static int levelOrderBFS(TreeNode root)
    {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int level = 1;
        int[] maxSumLevel = new int[]{root.val, 1};
        
        queue.offer(root);
        
        while(!queue.isEmpty())
        {
            int currSum = 0;
            int size = queue.size();
            while(size-->0)
            {
                TreeNode curr = queue.poll();
                currSum += curr.val;
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            if(currSum > maxSumLevel[0]) 
            {
                maxSumLevel[0] = currSum;
                maxSumLevel[1] = level;
            }
            level++;
        }
        
        return maxSumLevel[1];
    }
    
    private static int preorderDFS(TreeNode root)
    {
        Map<Integer, Integer> map = new HashMap<>();
        
        preorder(root, 1, map);
        
        int maxSumLevel = 1;
        int maxSum = root.val;
        
        for(int level : map.keySet())
        {
            int sum = map.get(level);
            if(sum > maxSum) 
            {
                maxSumLevel = level;
                maxSum = sum;
            }
        }
        
        return maxSumLevel;
    }
    
    private static void preorder(TreeNode root, int level, Map<Integer, Integer> map)
    {
        if(root==null) return;
        
        if(!map.containsKey(level)) map.put(level, root.val);
        else map.put(level, map.get(level)+root.val);
        
        preorder(root.left, level+1, map);
        preorder(root.right, level+1, map);
    }
}
