package Arrays;

public class Ques12 {

}

class Solution {

    // amount of water = length of subarray * (min of both heights)

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int water;

        while (i != j) {
            if (height[i] > height[j]) {
                water = height[j] * (j - i);
                j--;
            } else {
                water = height[i] * (j - i);
                i++;
            }

            if (max < water)
                max = water;
        }
        return max;
    }
}
