// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;

        int delay = n;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (delay < 0) {
                slow = slow.next;
            }
            delay--;
            fast = fast.next;
        }

        if (delay == 0) {
            return slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}