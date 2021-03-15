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
        return reverseListUtil(head, null);
    }
    
    private ListNode reverseListUtil(ListNode head, ListNode newHead) {
        if(head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListUtil(next, head);
    }
}
