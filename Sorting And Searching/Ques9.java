public class Ques9 {

}

// O(log n) implementation
class Solution {

    public int findPeakElement(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }

        int mid = (l + r) / 2;

        if (nums[mid] < nums[mid + 1]) {
            return helper(nums, mid + 1, r);
        }
        return helper(nums, l, mid);
    }
}

// O(n) solution
class Solution2 {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
