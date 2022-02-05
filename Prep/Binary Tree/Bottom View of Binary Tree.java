//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#

class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Deque<Node> queue = new ArrayDeque<>();
        
        root.hd = 0;
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            int dist = curr.hd;
            map.put(dist, curr.data);
            
            if(curr.left != null) {
                curr.left.hd = dist - 1;
                queue.offer(curr.left);
            }
            if(curr.right != null) {
                curr.right.hd = dist + 1;
                queue.offer(curr.right);
            }
        }
        
        for(Integer data : map.values()) {
            ans.add(data);
        }
        
        return ans;
    }
}
