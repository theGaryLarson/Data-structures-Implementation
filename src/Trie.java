import java.util.HashMap;
/** <a href="https://www.baeldung.com/trie-java">Baeldung Tutorial</a>
 * <a href="https://github.com/eugenp/tutorials/blob/master/data-structures
 * /src/main/java/com/baeldung/trie/Trie.java">Baeldung Github</a>
 *
 * <a href="https://www.geeksforgeeks.org/introduction-to-trie-data-structure-
 * and-algorithm-tutorials/">Geeks for Geeks Tutorial</a>
 * */
public class Trie {
     private final TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public boolean isPrefix(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if (current.children.get(c) == null) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }
    
    public boolean find(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.children.get(ch);
            if ( node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord;
    }
    
    public boolean delete(String word) {
        return delete(root, word, 0);
    }
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.isEmpty();
        }
       
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord;
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }
    
    public boolean isEmpty() {
        return root == null;
    }
    
    
    
    public static class TrieNode {
        public final HashMap<Character, TrieNode> children;
        public char value;
        public boolean isEndOfWord;
        
        public TrieNode() {
            /** stores characters associated with our sequence */
            children = new HashMap<>();
            /** character in node */
            /** tracks whether this node is an end of a word */
            isEndOfWord = false;
        }
    }
}
