import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class MinHeapTest {
 
    @Test
    void compareTo() {
        String a = "a";
        String b = "b";
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
        System.out.println("b.compareTo(a) = " + b.compareTo(a));
    }
    
    @Test
    void growTest() {
        MinHeap<String> minHeap = new MinHeap<>(3);
        minHeap.insert("d");
        minHeap.insert("c");
        minHeap.insert("b");
        minHeap.insert("a");
        assertTrue(minHeap.size() > 3);
        
    }
}