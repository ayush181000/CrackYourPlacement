public class Ques15 {

}

class Solution {

    public int splitArray(int[] nums, int m) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int num : nums) {
            low = Math.max(num, low);
            high = high + num;
        }

        int ans = high;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossible(nums, mid, m)) {
                ans = Math.min(ans, mid);
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] nums, int mid, int m) {
        int chunks = 0, i = 0;
        while (i < nums.length) {
            int val = 0;
            while (i < nums.length && nums[i] + val <= mid) {
                val += nums[i++];
            }
            chunks++;
        }
        return chunks <= m;
    }
}
