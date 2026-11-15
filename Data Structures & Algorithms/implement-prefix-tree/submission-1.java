class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode(){
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}


class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i<word.length();i++){
            char w = word.charAt(i);
            int idx = w - 'a';

            if (temp.children[idx] == null) {
                temp.children[idx] = new TrieNode();
            }
            
            temp = temp.children[idx];
        }

        temp.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i<word.length();i++){
            char w = word.charAt(i);
            int idx = w - 'a';

            if (temp.children[idx] == null) {
                return false;
            }
            
            temp = temp.children[idx];
        }
        return temp.isEndOfWord;
    }

    public boolean startsWith(String word) {
        TrieNode temp = root;
        for(int i = 0; i<word.length();i++){
            char w = word.charAt(i);
            int idx = w - 'a';

            if (temp.children[idx] == null) {
                return false;
            }
            
            temp = temp.children[idx];
        }

        return true;
    }
}
