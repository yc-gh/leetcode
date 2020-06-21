//https://leetcode.com/problems/recover-binary-search-tree/

class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode pre=null, temp=null, first=null, second=null;
        
        while(root!=null)
        {
            if(root.left!=null)
            {
                temp = root.left;
                
                while(temp.right!=null && temp.right!=root) temp=temp.right;
                
                if(temp.right==null)
                {
                    temp.right = root;
                    root = root.left;
                }
                else //Inorder printing done here
                {
                    if(pre!=null && pre.val>root.val)
                    {
                        if(first==null) first = pre;
                        second = root;
                    }
                    
                    temp.right = null;
                    pre = root;
                    root = root.right;
                }
                
                
            }
            else //Inorder printing done here 
            {
                
                if(pre!=null && pre.val>root.val)
                {
                    if(first==null) first = pre;
                    second = root;
                }
                
                pre = root;
                root = root.right;
            }
        }
        
        //Swap nodes
        if(first!=null && second!=null)
        {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
