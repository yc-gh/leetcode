// https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode newhead = null;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        if(curr1.val < curr2.val)
        {
            newhead = curr1;
            curr1 = curr1.next;
        }
        else
        {
            newhead = curr2;
            curr2 = curr2.next;
        }
        ListNode newcurr = newhead;
        while(curr1!=null && curr2!=null)
        {
            if(curr1.val < curr2.val)
            {
                newcurr.next = curr1;
                newcurr = curr1;
                curr1 = curr1.next;
            }
            else
            {
                newcurr.next = curr2;
                newcurr = curr2;
                curr2 = curr2.next;
            }
        }
        
        if(curr1!=null)
        {
            newcurr.next = curr1;
            newcurr = curr1;
        }
        if(curr2!=null)
        {
            newcurr.next = curr2;
            newcurr = curr2;
        }
        
        return newhead;
    }
}