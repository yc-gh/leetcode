//https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Deque<Node> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ans.add(queue.peekFirst().data);
            
            while(size --> 0) {
                Node curr = queue.pollFirst();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        
        return ans;
    }
}
