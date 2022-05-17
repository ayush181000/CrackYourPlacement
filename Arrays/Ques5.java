package Arrays;

class Solution {

    public void moveZeroes(int[] nums) {
        int nonUpdated = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonUpdated++] = nums[i];
            }
        }

        for (int i = nonUpdated; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
