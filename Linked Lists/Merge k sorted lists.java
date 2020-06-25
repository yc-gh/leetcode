// https://leetcode.com/problems/merge-k-sorted-lists/

// Merge sort nlogk
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergesort(lists, 0, lists.length-1);
    }

    private static ListNode mergesort(ListNode[] lists, int low, int high)
    {
        if(low==high) return lists[low];
        if(low<high)
        {
            int mid = low + (high-low)/2;
            ListNode l1 = mergesort(lists, low, mid);
            ListNode l2 = mergesort(lists, mid+1, high);
            return merge(l1,l2);
        }
        else return null;
    }
    
    private static ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val)
        {
            l1.next = merge(l1.next,l2);
            return l1;
        }
        else
        {
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
}

// Priority Queue nlogk
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k, (a,b)->a.val-b.val);
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for(int i=0; i<k; i++)
        {
            if(lists[i]!=null) pq.offer(lists[i]);
        }
        while(!pq.isEmpty())
        {
            curr.next = pq.poll();
            curr = curr.next;
            if(curr.next!=null)
                pq.offer(curr.next);
        } 
        return head.next;
    }
}