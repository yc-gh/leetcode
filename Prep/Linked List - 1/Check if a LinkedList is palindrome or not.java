//https://leetcode.com/problems/palindrome-linked-list/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(fast != null) slow = slow.next;
        
        slow = reverse(slow);
        fast = head;
        
        while(slow != null) {
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null) return null;
        ListNode curr = head, prev = null;
        
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
