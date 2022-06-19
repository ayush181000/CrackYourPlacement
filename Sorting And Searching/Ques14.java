import java.util.*;

public class Ques14 {

}

class Solution {
    int[] counts;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        mergesort(nums, 0, n - 1, index);
        List<Integer> res = new ArrayList<>();
        for (int c : counts)
            res.add(c);
        return res;
    }

    public void mergesort(int[] nums, int start, int end, int[] index) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergesort(nums, start, mid, index);
        mergesort(nums, mid + 1, end, index);
        merge(nums, start, mid, end, index);
    }

    public void merge(int[] nums, int start, int mid, int end, int[] index) {
        int[] newindex = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int smallcount = 0;
        int idx = 0;
        while (i <= mid && j <= end) {
            if (nums[index[i]] > nums[index[j]]) {
                ++smallcount;
                newindex[idx++] = index[j++];
            } else {
                counts[index[i]] += smallcount;
                newindex[idx++] = index[i++];
            }
        }
        while (i <= mid) {
            counts[index[i]] += smallcount;
            newindex[idx++] = index[i++];
        }
        while (j <= end) {
            newindex[idx++] = index[j++];
        }
        for (int k = start; k <= end; ++k) {
            index[k] = newindex[k - start];
        }
    }
}

class Solution2 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        List<Integer> li = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = binarySearch(li, nums[i]);
            li.add(index, nums[i]);
            // System.out.println(index+" "+li+" "+nums[i]);
            ans.add(index);
        }
        Collections.reverse(ans);
        return ans;
    }

    public int binarySearch(List<Integer> li, int element) {
        int low = 0;
        int high = li.size() - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == 0) {
                if (li.get(mid) >= element)
                    return 0;
                else if (li.get(high) < element)
                    return high + 1;
                else
                    return 1;
            }
            if (li.get(mid) >= element && li.get(mid - 1) < element) {
                return mid;
            } else if (li.get(mid) >= element && li.get(mid - 1) >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return li.size();
    }
}
