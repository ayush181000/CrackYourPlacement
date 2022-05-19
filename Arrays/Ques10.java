package Arrays;

import java.util.HashMap;
import java.util.Map;

public class Ques10 {

}

class Solution {

    public int subarraysDivByK(int[] n, int k) {

        Map<Integer, Integer> nm = new HashMap<>();

        int c = 0, p = n.length, s = 0;
        nm.put(s, 1);
        for (int i = 0; i < p; i++) {
            s = s + n[i];
            s %= k;
            if (s < 0)
                s += k; // for case any negative number % k we want positive part (-1%5=4)
            if (nm.containsKey(s))
                c += nm.get(s);
            nm.put(s, nm.getOrDefault(s, 0) + 1);
        }
        return c;
    }
}
