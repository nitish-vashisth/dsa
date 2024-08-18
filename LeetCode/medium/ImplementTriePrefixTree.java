package LeetCode.medium;

// 208. Implement Trie (Prefix Tree)

public class ImplementTriePrefixTree {
}

class Trie {

    public boolean endOfWord;
    public Trie[] child;

    public Trie() {
        this.endOfWord = false;
        this.child = new Trie[26];
    }

    public void insert(String word) {

        Trie curr = this;

        for(char c : word.toCharArray()) {
            Trie cNode = null;
            int key = (int)c - 97;
            if(curr.child[key] == null)
                cNode = new Trie();
            else
                cNode = curr.child[key];

            curr.child[key] = cNode;
            curr = cNode;
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {

        Trie curr = this;

        for(char c : word.toCharArray()) {
            if(curr == null)
                return false;

            int key = (int)c - 97;

            Trie cNode = curr.child[key];

            if(cNode == null)
                return false;

            curr = cNode;
        }

        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {

        Trie curr = this;

        for(char c : prefix.toCharArray()) {
            if(curr == null)
                return false;

            int key = (int)c - 97;

            Trie cNode = curr.child[key];

            if(cNode == null)
                return false;

            curr = cNode;
        }

        return true;
    }
}
