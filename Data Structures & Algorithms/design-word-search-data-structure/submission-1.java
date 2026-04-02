class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    public TrieNode(){
        isWord = false;
        children = new HashMap<>();
    }

}


class WordDictionary {
    private TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()){
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        
        
        
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, TrieNode node){
        TrieNode cur = node;

        for (int i = j; i < word.length(); i++){
            char c = word.charAt(i);
            if (c == '.'){
                for (TrieNode child: cur.children.values()){
                    if (dfs(word, i + 1, child)){
                        return true;
                    }                    
                }
                return false;
            }else{
                if(!cur.children.containsKey(c)){
                    return false;
                }
                cur = cur.children.get(c);
            }
        }

        return cur.isWord;

    }
}
