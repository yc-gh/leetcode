//https://leetcode.com/problems/reverse-nodes-in-k-group/

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        while(curr != null && ++count < k) {
            curr = curr.next;
        }
        
        if(curr == null) return head;
        
        ListNode next = reverseKGroup(curr.next, k);
        curr.next = null;
        ListNode reversedHead = reverse(head);
        head.next = next;
        return reversedHead;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
