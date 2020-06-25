// https://leetcode.com/problems/copy-list-with-random-pointer/


// Constant extra space 

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        
        Node orignode = head;
        
        while(orignode != null)
        {
            Node next = orignode.next;
            Node copynode = new Node(orignode.val);
            copynode.next = next;
            orignode.next = copynode;
            orignode = next;
        }
        
        orignode = head;
        
        while(orignode != null)
        {
            if(orignode.random != null)
                orignode.next.random = orignode.random.next;
            orignode = orignode.next.next;
        }
        
        orignode = head;
        Node copyhead = new Node(0);
        Node copynode = copyhead;
        
        while(orignode != null)
        {
            Node next = orignode.next.next;
            copynode.next = orignode.next;
            copynode = copynode.next;
            orignode.next = next;
            orignode = next;
        }
        
        return copyhead.next;
    }
}

// Hashing approach extra space
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        
        Map<Node,Node> map = new HashMap<>();
        
        Node orignode = head;
        while(orignode != null)
        {
            map.put(orignode, new Node(orignode.val));
            orignode = orignode.next;
        }
        
        orignode = head;
        
        while(orignode != null)
        {
            Node newnode = map.get(orignode);
            newnode.next = map.get(orignode.next);
            newnode.random = map.get(orignode.random);
            orignode = orignode.next;
        }
        
        return map.get(head);
        
    }
}