// https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {

    // static int pivot(int[] nums, int low, int high)
    // {
    // int pivot = nums[high];
    // int index = low;

    // for(int i=low; i<=high; i++)
    // {
    // if(nums[i]>pivot)
    // {
    // int temp = nums[i];
    // nums[i] = nums[index];
    // nums[index] = temp;
    // index++;
    // }
    // }

    // int temp = nums[index];
    // nums[index] = nums[high];
    // nums[high] = temp;

    // return index;
    // }

    static int quickSelect(int[] nums, int low, int high, int k) {
        // int pivot = pivot(nums, low, high);

        int pivot = nums[high];
        int index = low;

        for (int i = low; i < high; i++) {
            if (nums[i] > pivot) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }

        int temp = nums[index];
        nums[index] = nums[high];
        nums[high] = temp;

        if (index == k) {
            return nums[index];
        }

        if (index < k) {
            return quickSelect(nums, index + 1, high, k);
        }

        else {
            return quickSelect(nums, low, index - 1, k);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
}