// https://leetcode.com/problems/intersection-of-two-linked-lists/

// Optimised
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode A = headA, B = headB;

        while (A != B) {
            A = (A == null) ? headB : A.next;
            B = (B == null) ? headA : B.next;
        }

        return A;
    }
}


// Slowest approach
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;

        while (currA != null) {
            while (currB != null) {
                if (currA == currB)
                    return currA;
                currB = currB.next;
            }
            currA = currA.next;
            currB = headB;
        }

        return null;
    }
}