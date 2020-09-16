//https://leetcode.com/problems/n-ary-tree-preorder-traversal/

class Solution {
    public List<Integer> preorder(Node root) {
        if(root==null) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        list.add(root.val);
        
        for(Node child : root.children)
        {
            list.addAll(preorder(child));
        }
        
        return list;
    }
    
    public List<Integer> preorder(Node root)
    {
        if(root==null) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            Node curr = stack.pop();
            res.add(curr.val);
            
            for(int i = curr.children.size()-1; i>=0; i--)
            {
                stack.push(curr.children.get(i));
            }
        }
        
        return res;
    }
}
