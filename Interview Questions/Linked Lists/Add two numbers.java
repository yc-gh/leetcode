// https://leetcode.com/problems/add-two-numbers/

//Concise
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int sum = 0;
        while(c1!=null || c2!=null)
        {
            sum /= 10; //Carry
            if(c1!=null)
            {
                sum += c1.val;
                c1 = c1.next;
            }
            
            if(c2!=null)
            {
                sum += c2.val;
                c2 = c2.next;
            }
            
            prev.next = new ListNode(sum%10);
            prev = prev.next;
        }
        
        if(sum/10==1) prev.next = new ListNode(1);
            
        return head.next;
    }
}

// Optimised
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while(curr1!=null && curr2!=null)
        {
            int sum = curr1.val + curr2.val + carry;
            carry = sum/10;
            ListNode newNode = new ListNode(sum%10);
            prev.next = newNode;
            prev = newNode;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        if(carry==0)
        {
            if(curr1!=null) prev.next = curr1;
            else if(curr2!=null) prev.next = curr2;
        }
        else
        {
            // while(curr1!=null)
            // {
            //     int sum = curr1.val + carry;
            //     carry = 0;
            //     if(sum>9) carry=1;
            //     ListNode newNode = new ListNode(sum%10);
            //     prev.next = newNode;
            //     prev = newNode;
            //     curr1 = curr1.next;
            // }
            // while(curr2!=null)
            // {
            //     int sum = curr2.val + carry;
            //     carry = 0;
            //     if(sum>9) carry=1;
            //     ListNode newNode = new ListNode(sum%10);
            //     prev.next = newNode;
            //     prev = newNode;
            //     curr2 = curr2.next;
            // }
            
            while(curr1!=null)
            {
                if(curr1.val<9)
                {
                    prev.next = new ListNode(curr1.val+carry);
                    prev.next.next = curr1.next;
                    carry = 0;
                    break;
                }
                else
                {
                    int sum = curr1.val + carry;
                    carry = sum/10;
                    prev.next = new ListNode(sum%10);
                    prev = prev.next;
                    curr1 = curr1.next;
                }
            }
            while(curr2!=null)
            {
                if(curr2.val<9)
                {
                    prev.next = new ListNode(curr2.val+carry);
                    prev.next.next = curr2.next;
                    carry = 0;
                    break;
                }
                else
                {
                    int sum = curr2.val + carry;
                    carry = sum/10;
                    prev.next = new ListNode(sum%10);
                    prev = prev.next;
                    curr2 = curr2.next;
                }
            }
            
            if(carry==1) prev.next = new ListNode(1);
        }
        
        return head.next;
    }
}