package Arrays;

import java.util.*;

public class Ques14 {

}

class Solution {

    // With the help of 3sum and 2sum
    // we have call 3sum to every i+1 element and consecutively called to 2sum for
    // every element to get quadruple set
    private List<List<Integer>> twoSum(int[] nums, int tar, int idx) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = idx;
        int j = nums.length - 1;

        while (i < j) {
            if (i - 1 >= idx && nums[i - 1] == nums[i]) {
                i++;
                continue;
            }
            if (nums[i] + nums[j] == tar) {
                List<Integer> res = new ArrayList<>();
                res.add(nums[i]);
                res.add(nums[j]);
                ans.add(res);
                i++;
                j--;
            } else if (nums[i] + nums[j] > tar) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int si, int[] nums, int target) {
        // target sum unique pairs
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = si; i < nums.length - 2; i++) {
            if (i - 1 >= si && nums[i - 1] == nums[i]) {
                // i++;
                continue;
            }
            List<List<Integer>> pairs = twoSum(nums, target - nums[i], i + 1);
            for (List<Integer> pair : pairs) {
                pair.add(nums[i]);
                ans.add(pair);
            }
        }
        return ans;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 3; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> res = threeSum(i + 1, nums, target - nums[i]);

            for (List<Integer> pair : res) {
                pair.add(nums[i]);
                ans.add(pair);
            }
        }
        return ans;
    }
}
