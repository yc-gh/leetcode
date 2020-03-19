// https://leetcode.com/problems/odd-even-linked-list/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode currOdd = oddHead;
        ListNode currEven = evenHead;

        ListNode nextOdd, nextEven;

        while (currEven != null && currEven.next != null) {
            nextOdd = currEven.next;
            nextEven = nextOdd.next;

            currOdd.next = nextOdd;
            currEven.next = nextEven;

            currOdd = nextOdd;
            currEven = nextEven;
        }

        currOdd.next = evenHead;

        return oddHead;
    }
}