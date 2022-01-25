//https://leetcode.com/problems/add-two-numbers/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        
        ListNode curr1 = l1, curr2 = l2;
        ListNode newHead = new ListNode(0), newCurr = newHead;
        
        while(curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + carry;
            int sumVal = sum % 10;
            carry = sum / 10;
            
            newCurr.next = new ListNode(sumVal);
            newCurr = newCurr.next;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        while(curr1 != null) {
            int sum = curr1.val + carry;
            int sumVal = sum % 10;
            carry = sum / 10;
            
            newCurr.next = new ListNode(sumVal);
            newCurr = newCurr.next;
            
            curr1 = curr1.next;
        }
        
        while(curr2 != null) {
            int sum = curr2.val + carry;
            int sumVal = sum % 10;
            carry = sum / 10;
            
            newCurr.next = new ListNode(sumVal);
            newCurr = newCurr.next;
            
            curr2 = curr2.next;
        }
        
        if(carry != 0) {
            newCurr.next = new ListNode(carry);
            newCurr = newCurr.next;
        }
        
        newCurr.next = null;
        
        return newHead.next;
    }
}
