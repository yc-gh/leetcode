//https://leetcode.com/problems/copy-list-with-random-pointer/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node curr = head;
        
        while(curr != null) {
            Node copyCurr = new Node(curr.val);
            Node next = curr.next;
            curr.next = copyCurr;
            copyCurr.next = next;
            
            curr = next;
        }
        
        curr = head;
        Node copyHead = head.next;
        
        while(curr != null) {
            if(curr.random != null) curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        
        curr = head;
        
        while(curr != null) {
            Node next = curr.next.next;
            if(next != null) {
                Node copyNext = next.next;
                curr.next.next = copyNext;
                curr.next = next;
            }
            else {
                curr.next = null;
            }
            curr = next;
        }
        
        return copyHead;
    }
}
