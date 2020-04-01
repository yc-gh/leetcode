// https://leetcode.com/problems/min-stack/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


 //Using double operation approach - keep min element with each operation
 //This approach is useful if min element is required in a proper stack
class MinStack {

    /** initialize your data structure here. */
    
    List<Integer> list;
    
    public MinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int x) {
        
        if(list.isEmpty())
        {
            list.add(x);
            list.add(x);
        }
        else
        {
            int currmin = getMin();
            if(x < currmin)
            {
                list.add(x);
                list.add(x);
            }
            else
            {
                list.add(x);
                list.add(currmin);
            }
        }
    }
    
    public void pop() {
        if(!list.isEmpty())
        {
            list.remove(list.size()-1);
            list.remove(list.size()-1);
        }   
    }
    
    public int top() {
        return list.get(list.size()-2);
    }
    
    public int getMin() {
        return list.get(list.size()-1);
    }
}


//Efficient approach
class MinStack {

    /** initialize your data structure here. */
    
    List<Integer> list;
    Integer min;
    
    public MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        list.add(x);
        if(x < min)
        {
            min = x;
        }
    }
    
    public void pop() {
        if(list.get(list.size()-1).equals(min))
        {
            min = Integer.MAX_VALUE;
            list.remove(list.size()-1);
            for(int i : list)
            {
                if(i < min)
                {
                    min = i;
                }
            }
        }
        else
        {
            list.remove(list.size()-1);
        }
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return min;
    }
}