package Arrays;

public class Ques22 {

}

class Solution {

    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        int res = mergeSort(nums, temp, 0, nums.length - 1);
        return res;
    }

    private int mergeSort(int[] nums, int[] tmp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int res = 0;
        int mid = (start + end) / 2;
        res += mergeSort(nums, tmp, start, mid);
        res += mergeSort(nums, tmp, mid + 1, end);
        int right = mid + 1;
        int j = mid + 1;
        int index = start;
        for (int left = start; left <= mid; left++) {
            while (j <= end && (long) nums[left] > 2 * (long) nums[j]) {
                j++;
            }
            res += j - mid - 1;
            while (right <= end && nums[right] < nums[left]) {
                tmp[index++] = nums[right++];
            }
            tmp[index++] = nums[left];
        }
        while (right <= end) {
            tmp[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[i];
        }
        return res;
    }
}
