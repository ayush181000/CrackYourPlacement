package Trie;

import java.util.*;

public class Ques4 {

}

// TODO: My solution
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        ArrayList<int[]> l = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s : string_list) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
            }

            l.add(map);
        }

        boolean[] visited = new boolean[string_list.length];

        for (int i = 0; i < l.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                List<String> strings = new ArrayList<>();
                strings.add(string_list[i]);
                int[] arr1 = l.get(i);

                for (int j = i + 1; j < l.size(); j++) {
                    int[] arr2 = l.get(j);
                    if (Arrays.equals(arr1, arr2)) {
                        visited[j] = true;
                        strings.add(string_list[j]);
                    }
                }

                ans.add(strings);
            }
        }

        return ans;
    }
}

// TODO: my solution optimized version
class FindAnagrams {

    private static ArrayList<ArrayList<String>> solver(
            ArrayList<String> list) {

        // Inner hashmap counts frequency
        // of characters in a string.
        // Outer hashmap for if same
        // frequency characters are present in
        // in a string then it will add it to
        // the arraylist.
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<HashMap<Character, Integer>, ArrayList<String>>();
        for (String str : list) {
            HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();

            // Counting the frequency of the
            // characters present in a string
            for (int i = 0; i < str.length(); i++) {
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                } else {
                    tempMap.put(str.charAt(i), 1);
                }
            }

            // If the same frequency of characters
            // are already present then add that
            // string into that arraylist otherwise
            // created a new arraylist and add that string
            if (map.containsKey(tempMap))
                map.get(tempMap).add(str);
            else {
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }

        // Stores the result in a arraylist
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet())
            result.add(map.get(temp));
        return result;
    }

    // Drivers Method
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("ogd");
        list.add("god");
        list.add("atc");

        System.out.println(solver(list));
    }
}

// TODO:Trie solution
class GFG2 {
    static final int NO_OF_CHARS = 26;

    // Class to represent a Trie Node
    static class TrieNode {
        boolean isEnd; // indicates end of word

        // 26 slots each for 'a' to 'z'
        TrieNode[] child = new TrieNode[NO_OF_CHARS];

        // head of the index list
        LinkedList<Integer> head;

        // constructor
        public TrieNode() {
            isEnd = false;
            head = new LinkedList<>();
            for (int i = 0; i < NO_OF_CHARS; ++i)
                child[i] = null;
        }
    }

    // A utility function to insert a word to Trie
    static TrieNode insert(TrieNode root, String word,
            int index, int i) {
        // Base case
        if (root == null) {
            root = new TrieNode();
        }

        if (i < word.length()) {
            int index1 = word.charAt(i) - 'a';
            root.child[index1] = insert(root.child[index1],
                    word, index, i + 1);
        } else // If end of the word reached
        {
            // Insert index of this word to end of
            // index linked list
            if (root.isEnd == true) {
                root.head.add(index);
            } else // If Index list is empty
            {
                root.isEnd = true;
                root.head.add(index);
            }
        }
        return root;
    }

    // This function traverses the built trie. When a leaf
    // node is reached, all words connected at that leaf
    // node are anagrams. So it traverses the list at leaf
    // node and uses stored index to print original words
    static void printAnagramsUtil(TrieNode root,
            String wordArr[]) {
        if (root == null)
            return;

        // If a lead node is reached, print all anagrams
        // using the indexes stored in index linked list
        if (root.isEnd) {
            // traverse the list
            for (Integer pCrawl : root.head)
                System.out.println(wordArr[pCrawl]);
        }

        for (int i = 0; i < NO_OF_CHARS; ++i)
            printAnagramsUtil(root.child[i], wordArr);
    }

    // The main function that prints all anagrams together.
    // wordArr[] is input sequence of words.
    static void printAnagramsTogether(String wordArr[],
            int size) {
        // Create an empty Trie
        TrieNode root = null;

        // Iterate through all input words
        for (int i = 0; i < size; ++i) {
            // Create a buffer for this word and copy the
            // word to buffer
            char[] buffer = wordArr[i].toCharArray();

            // Sort the buffer
            Arrays.sort(buffer);

            // Insert the sorted buffer and its original
            // index to Trie
            root = insert(root, new String(buffer), i, 0);

        }

        // Traverse the built Trie and print all anagrams
        // together
        printAnagramsUtil(root, wordArr);
    }

    // Driver program to test above functions
    public static void main(String args[]) {
        String wordArr[] = { "cat", "dog", "tac", "god",
                "act", "gdo" };
        int size = wordArr.length;
        printAnagramsTogether(wordArr, size);
    }
}
// This code is contributed by Sumit Ghosh
