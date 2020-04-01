// https://leetcode.com/problems/shuffle-an-array/

class Solution {

    int[] nums;
    private Random r;
	public Solution(int[] nums) {
		this.nums = nums;
        r = new Random();
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return nums;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] res = new int[nums.length];
		res = nums.clone();
        int n = res.length;

        r = new Random();
        
		for (int i = n-1; i > 0; i--) { 
              
            // Pick a random index from 0 to i 
            int j = r.nextInt(i+1); 
              
            // Swap res[i] with the element at random index 
            int temp = res[i]; 
            res[i] = res[j]; 
            res[j] = temp; 
        }
		return res;
	}
}