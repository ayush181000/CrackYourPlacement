package Arrays;

public class Ques21 {

}

class Solution {

    // Moore's sorting algo
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == val) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    val = nums[i];
                    count = 1;
                }
            }
            i++;
        }
        return val;
    }
}
