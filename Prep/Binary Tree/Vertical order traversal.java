//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

class Solution {
    
    class UtilNode {
        TreeNode node;
        Integer col;
        
        UtilNode(TreeNode n, Integer c) {
            this.node = n;
            this.col = c;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        Deque<UtilNode> queue = new ArrayDeque<>();
        
        queue.offer(new UtilNode(root, 0));
        
        while(!queue.isEmpty()) {
            Map<Integer, List<Integer>> tempColMap = new HashMap<>();
            int size = queue.size();
            
            while(size --> 0) {
                UtilNode curr = queue.poll();
                TreeNode node = curr.node;
                Integer col = curr.col;

                List<Integer> tempList = tempColMap.getOrDefault(col, new ArrayList());
                tempList.add(node.val);
                if(!tempColMap.containsKey(col)) tempColMap.put(col, tempList);

                if(node.left != null) queue.offer(new UtilNode(node.left, col-1));
                if(node.right != null) queue.offer(new UtilNode(node.right, col+1));

            }
            
            for(int key : tempColMap.keySet())
            {
                List<Integer> temp = tempColMap.get(key);
                Collections.sort(temp);
                if(!map.containsKey(key)) {
                    map.put(key, temp);
                }
                else                 {
                    map.get(key).addAll(temp);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(List<Integer> list : map.values()) {
            ans.add(list);
        }
        
        return ans;
    }
}
