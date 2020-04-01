// https://leetcode.com/problems/reverse-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null)
        {
            return head;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        prev.next = null;
        while(curr.next != null)
        {
            ListNode currnext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currnext;
        }
        curr.next = prev;
        return curr;
    }
}


//Recursive Solution
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode newHead = reverseListUtil(head);
        head.next = null;
        return newHead;
    }
    
    ListNode reverseListUtil(ListNode curr)
    {
        if(curr.next.next == null)
        {
            ListNode newhead = curr.next;
            newhead.next = curr;
            return newhead;
        }
        ListNode newhead = reverseListUtil(curr.next);
        ListNode currnext = curr.next;
        currnext.next = curr;
        return newhead;
    }
}