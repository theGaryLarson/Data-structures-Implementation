import java.util.Arrays;

public class TrieST<K>
{
    private static int R = 256; // radix
    private Node<K> root; // root of trie
    
    public K get(String key) {
        Node<K> x = get(root, key, 0);
        if (x == null) return null;
        return (K) x.val;
    }
    private Node<K> get(Node<K> x, String key, int d) {
        // Return K associated with key in the subtrie rooted at x.
        if (x == null) {
            return null;
        }
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }
    public void put(String key, K val) {
        root = put(root, key, val, 0);
    }
    
    private Node<K> put(Node<K> x, String key, K val, int d) {
        // Change K associated with key if in subtrie rooted at x.
        if (x == null) {
            x = new Node<>();
        }
        if (d == key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    
    private static class Node<T>
    {
        private T val;
        private Node<T>[] template;
        private final Node<T>[] next = Arrays.copyOf(template, R);
    
        private Node() {
        }
    }
}