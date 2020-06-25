//https://leetcode.com/problems/sum-root-to-leaf-numbers/

class Solution {
    public int sumNumbers(TreeNode root) {
        return genNumbers(root, new StringBuilder());
    }
    
    private static int genNumbers(TreeNode root, StringBuilder sb)
    {
        if(root==null) 
        {
            return 0;
        }
        sb.append(root.val);
        if(root.left==null && root.right==null)
        {
            int currNum = Integer.parseInt(sb.toString());
            sb.setLength(sb.length()-1);
            return currNum;
        }
        int leftNum = genNumbers(root.left, sb);
        int rightNum = genNumbers(root.right, sb);
        sb.setLength(sb.length()-1);
        return leftNum+rightNum;
    }
}
