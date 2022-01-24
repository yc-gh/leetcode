//https://leetcode.com/problems/merge-two-sorted-lists/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        if(list1 == null && list2 == null) return null;
        
        ListNode curr1 = list1, curr2 = list2;
        ListNode newHead = new ListNode(0), newCurr = newHead;
        
        while(curr1 != null && curr2 != null) {
            if(curr1.val < curr2.val) {
                newCurr.next = curr1;
                newCurr = curr1;
                curr1 = curr1.next;
            }
            else {
                newCurr.next = curr2;
                newCurr = curr2;
                curr2 = curr2.next;
            }
        }
        
        while(curr1 != null) {
            newCurr.next = curr1;
            newCurr = curr1;
            curr1 = curr1.next;
        }
        
        while(curr2 != null) {
            newCurr.next = curr2;
            newCurr = curr2;
            curr2 = curr2.next;
        }
        
        return newHead.next;
    }
}
