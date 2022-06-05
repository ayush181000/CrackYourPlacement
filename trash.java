import java.util.*;

public class trash {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 })));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length - 1; i++) {
            int comp = nums2[i];
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > comp) {
                    map.put(comp, nums2[j]);
                    break;
                }
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}