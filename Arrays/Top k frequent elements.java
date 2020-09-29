// https://leetcode.com/problems/top-k-frequent-elements/

// Bucket sort 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length+1];
        
        for(int i : nums) map.put(i, map.getOrDefault(i,0)+1);
        
        for(int key : map.keySet())
        {
            int freq = map.get(key);
            if(bucket[freq]==null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        
        int[] ans = new int[k];
        int j=0;
        
        for(int i=bucket.length-1; i>=0 && j<k; i--)
        {
            if(bucket[i]!=null)
            {
                for(int next : bucket[i])
                {
                    if(j >= k) break;
                    ans[j++] = next;
                }
            }
        }
        
        return ans;
    }
}


// PriorityQueue

class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        List<Integer> result = new ArrayList<>();

        while (k-- > 0) {
            result.add(pq.poll().getKey());
        }

        return result;
    }
}

