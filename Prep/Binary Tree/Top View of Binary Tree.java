//https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

class Solution
{
    class UtilNode {
        Node node;
        Integer dist;
        
        UtilNode(Node n, Integer d) {
            this.node = n;
            this.dist = d;
        }
    }
    
    //Function to return a list containing the top view of the given tree.
    public ArrayList <Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Deque<UtilNode> queue = new ArrayDeque<>();
        
        queue.offer(new UtilNode(root,0));
        
        while(!queue.isEmpty()) {
            UtilNode curr = queue.poll();
            Node n = curr.node;
            Integer dist = curr.dist;
            if(!map.containsKey(dist)) map.put(dist, n.data);
            
            if(n.left != null) {
                queue.offer(new UtilNode(n.left, dist-1));
            }
            if(n.right != null) {
                queue.offer(new UtilNode(n.right, dist+1));
            }
        }
        
        for(Integer data : map.values()) {
            ans.add(data);
        }
        
        return ans;
    }
}
