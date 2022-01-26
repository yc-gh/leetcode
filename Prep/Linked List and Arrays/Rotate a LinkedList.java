//https://leetcode.com/problems/rotate-list/

//For right rotation -> subList(n-k, n) + subList(0, n-k)
//For left rotation -> subList(k, n) + subList(0, k)

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        int len = listLength(head);
        int modK = k % len;
        
        if(modK == 0) return head;
        
        ListNode first = head, second = head;
        
        while(first.next != null) {
            if(modK-- <= 0) second = second.next;
            first = first.next;
        }
        
        ListNode newHead = second.next;
        first.next = head;
        second.next = null;
        return newHead;
    }
    
    private int listLength(ListNode head) {
        if(head == null) return 0;
        
        int count = 0;
        for(ListNode curr = head; curr != null; curr = curr.next) {
            count++;
        }
        
        return count;
    }
}
