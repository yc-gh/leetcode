//https://leetcode.com/problems/linked-list-cycle/

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head, slow = head;
        
        do {
            if(fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);
        
        return fast == slow;
    }
}
