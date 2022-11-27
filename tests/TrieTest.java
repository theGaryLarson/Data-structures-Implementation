import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class TrieTest {
    
    
    @Test
    void insert() {
        Trie insertTest = exampleTrie();
        assertFalse(insertTest.isEmpty());
    }
    @Test
    void findTest() {
        Trie phrase = exampleTrie();
        assertTrue(phrase.find("This"));
        assertTrue(phrase.find("Structure!"));
        assertFalse(phrase.find("!"));
    }
    
    @Test
    void deleteTest() {
        Trie phrase = exampleTrie();
        assertTrue(phrase.find("Trie"));
        phrase.delete("Trie");
        assertFalse(phrase.find("Trie"));
    }
    
    @Test
    void isPrefixTest() {
        Trie phrase = exampleTrie();
        assertTrue(phrase.isPrefix("Thi"));
    }
    
    Trie exampleTrie() {
        Trie t = new Trie();
        t.insert("This");
        t.insert("is");
        t.insert("a");
        t.insert("Trie");
        t.insert("Data");
        t.insert("Structure!");
        return t;
    }
}