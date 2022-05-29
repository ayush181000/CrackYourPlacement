class Solution {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += nums[i] - min;
        }

        return res;
    }
}
