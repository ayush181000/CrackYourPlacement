package Strings;

import java.util.*;

public class Ques12 {

}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<>();

        List<List<String>> anagrams = new ArrayList<>();

        for (String word : strs) {
            int hash = getHash(word);
            List<String> list = map.get(hash);
            if (list == null) {
                list = new ArrayList<>();
                map.put(hash, list);
                anagrams.add(list);
            }
            list.add(word);
        }

        return anagrams;
    }

    public int getHash(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int chh = (s.charAt(i) - 'a' + 1);
            count += (chh * (17 + chh) * (23 + chh) * (29 + chh) * (41 + chh));
        }
        return count;
    }
}