//https://leetcode.com/problems/maximum-frequency-stack/

class FreqStack {

    Map<Integer, Deque<Integer>> group;
    Map<Integer, Integer> freq;
    int maxfreq;
    
    FreqStack()
    {
        group = new HashMap<>();
        freq = new HashMap<>();
    }
        
    public void push(int x) {
        int currfreq = freq.getOrDefault(x,0) + 1;
        freq.put(x, currfreq);
        if(currfreq > maxfreq) maxfreq = currfreq;
        
        group.computeIfAbsent(currfreq, z -> new ArrayDeque<>()).push(x);
    }
    
    public int pop() {
        Deque<Integer> g = group.get(maxfreq);
        int x = g.pop();
        freq.put(x, freq.get(x)-1);
        if(g.isEmpty()) maxfreq--;
        return x;
    }
}



/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
