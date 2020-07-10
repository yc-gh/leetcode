//https://leetcode.com/problems/unique-binary-search-trees-ii/

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return genTreeList(1,n);
    }
    
    private static List<TreeNode> genTreeList(int start, int end)
    {
        List<TreeNode> list = new ArrayList<>();
        if(start>end) list.add(null);
        for(int i=start; i<=end; i++)
        {
            List<TreeNode> left = genTreeList(start,i-1);
            List<TreeNode> right = genTreeList(i+1,end);
            for(TreeNode l : left)
            {
                for(TreeNode r : right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
