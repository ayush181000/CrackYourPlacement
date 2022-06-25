package Trie;

public class Ques1 {

}

class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        this.trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.hasNext(ch))
                curr.add(ch);
            curr = curr.next(ch);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, this.trie);
    }

    public boolean search(String word, TrieNode trie) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                String rest = word.substring(i + 1);
                for (TrieNode node : trie.trieNode) {
                    if (node != null && search(rest, node))
                        return true;
                }
                return false;
            }
            if (!trie.hasNext(ch))
                return false;
            trie = trie.next(ch);
        }
        if (!trie.isEnd)
            return false;
        return true;
    }
}

class TrieNode {
    TrieNode[] trieNode;

    boolean isEnd;

    public TrieNode() {
        this.trieNode = new TrieNode[26];
    }

    public void add(char ch) {
        this.trieNode[ch - 'a'] = new TrieNode();
    }

    public boolean hasNext(char ch) {
        if (this.trieNode[ch - 'a'] != null)
            return true;
        return false;
    }

    public TrieNode next(char ch) {
        return this.trieNode[ch - 'a'];
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
