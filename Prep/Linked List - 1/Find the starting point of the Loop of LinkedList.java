//https://leetcode.com/problems/linked-list-cycle-ii/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        
        ListNode fast = head, slow = head;
        
        do {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);
        
        if(fast != slow) {
          return null;  
        }
        
        fast = head;
        
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}
