// https://leetcode.com/problems/sort-list/

// Recursive merge sort
// Top down
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        head = sortList(head);
        midNext = sortList(midNext);
        head = merge(head,midNext);
        return head;
    }
    
    static ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode curr1=head1, curr2=head2;
        ListNode head=null;
        
        if(curr1.val < curr2.val) 
        {
            head = curr1;
            curr1 = curr1.next;
        }
        else
        {
            head = curr2;
            curr2 = curr2.next;
        }
        
        ListNode curr = head;
        
        while(curr1!=null && curr2!=null) 
        {
            if(curr1.val < curr2.val)
            {
                curr.next = curr1;
                curr1 = curr1.next;
            }
            else
            {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        
        if(curr1!=null)
        {
            curr.next = curr1;
        }
        else
        {
            curr.next = curr2;
        }
        
        return head;
    }
    
    static ListNode getMid(ListNode head)
    {
        ListNode slow=head, fast=head, prev=head;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return prev;
    }
}


// Iterative merge sort
// Bottom up
class Solution
{

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = 0;
        while (head != null) {
            head = head.next;
            n++;
        }
        
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
            } 
        }
        
        return dummy.next;
    }
    
    private ListNode split(ListNode head, int step) {
        if (head == null) return null;
        
        for (int i = 1; head.next != null && i < step; i++) {
            head = head.next;
        }
        
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    
    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        ListNode cur = prev;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            }
            else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        
        if (left != null) cur.next = left;
        else if (right != null) cur.next = right;
        while (cur.next != null) cur = cur.next;
        return cur;
    }
}