//https://leetcode.com/problems/clone-graph/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }
    
    private Node clone(Node node, Map<Node, Node> map) {
        if(node == null) return null;
        
        if(map.containsKey(node)) return map.get(node);
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        
        for(Node neighbor: node.neighbors) {
            copy.neighbors.add(clone(neighbor, map));
        }
        
        return copy;
    }
}
