//https://leetcode.com/problems/n-ary-tree-level-order-traversal/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        
        while(queue.size() > 0)
        {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while(size-->0)
            {
                Node curr = queue.poll();
                temp.add(curr.val);
                for(Node child : curr.children)
                {
                    queue.offer(child);
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}
