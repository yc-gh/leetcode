class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        ListNode curr1=l1, curr2=l2;
        while(curr1!=null && curr2!=null)
        {
            if(curr1.val<curr2.val)
            {
                prev.next = curr1;
                prev = curr1;
                curr1 = curr1.next;
            }
            else
            {
                prev.next = curr2;
                prev = curr2;
                curr2 = curr2.next;
            }
        }
        
        if(curr1!=null) prev.next=curr1;
        else if(curr2!=null) prev.next=curr2;
        
        return head.next;
    }
}
