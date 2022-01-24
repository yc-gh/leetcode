//https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n+1;
        
        ListNode first = head;
        ListNode second = head;
        
        while(first != null) {
            first = first.next;
            if(k == 0) {
                second = second.next;
            }
            else k--;
        }
        
        if(k > 0) return head.next;
        
        second.next = second.next.next;
        
        return head;
    }
}
