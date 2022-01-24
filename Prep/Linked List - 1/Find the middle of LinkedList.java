//https://leetcode.com/problems/middle-of-the-linked-list/

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
