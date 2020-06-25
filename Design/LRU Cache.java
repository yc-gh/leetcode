// https://leetcode.com/problems/lru-cache/

// Efficient doubly linked list for queue
class LRUCache {

    static class Node
    {
        int key;
        int value;
        Node next;
        Node prev;
        
        Node(int k, int v)
        {
            key = k;
            value = v;
        }
    }
    
    private static Map<Integer,Node> map;
    private static Node head,tail;
    private static int cap;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.cap = capacity; 
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    private static void addToHead(Node node)
    {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private static void deleteNode(Node node)
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            int v = node.value;
            deleteNode(node);
            addToHead(node);
            return v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key))
        {
            if(map.size()>=cap)
            {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            Node node = new Node(key,value);
            map.put(key,node);
            addToHead(node);
        }
        else
        {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
    }
}


// Inefficient - O(n) put operation
class LRUCache {
    Map<Integer,Integer> map;
    Deque<Integer> queue;
    int maxcap;
    
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity, 1f);
        queue = new ArrayDeque(capacity);
        maxcap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        else
        {
            queue.remove(key);
            queue.offer(key);
        }
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key))
        {
            if(map.size()>=maxcap)
            {
                map.remove(queue.poll());
            }
        }
        else
        {
            queue.remove(key);
        }
        map.put(key,value);
        queue.offer(key);
    }
}

// Using inbuilt library
public class LRUCache {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}