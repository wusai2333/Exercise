class WordDictionary {
        class TrieNode {
            public TrieNode[] children;
            public String word;
            TrieNode() {
                children = new TrieNode[26];
            }
        }

        public TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }
        
        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children[c-'a'] == null) 
                    node.children[c-'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        
        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }
        private boolean match(char[] word, int depth, TrieNode node) {
            if (depth == word.length) return node.word != null;
            if (word[depth] != '.') {
                char c = word[depth];
                return node.children[c - 'a'] != null && match(word, depth+1, node.children[c - 'a']);
            } else {
                for (int i = 0; i < node.children.length; i ++) {
                    if (node.children[i] != null) {
                        if (match(word, depth+1, node.children[i])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
    
    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */