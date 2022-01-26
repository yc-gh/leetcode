//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node curr = head;
        
        while(curr != null) {
            Node next = curr.next;
            
            if(curr.child != null) {
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;
                
                while(curr.next != null) curr = curr.next;
                
                curr.next = next;
                if(next != null) next.prev = curr;
            }
            
            curr = curr.next;
        }
        
        return head;
    }
}
