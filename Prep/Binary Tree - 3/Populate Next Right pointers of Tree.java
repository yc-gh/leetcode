//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        
        Node levelStart = root;
        while(levelStart != null) {
            Node curr = levelStart;
            while(curr != null) {
                if(curr.left != null) {
                    curr.left.next = curr.right;
                }
                if(curr.next != null && curr.right != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
        
        return root;
    }
}
