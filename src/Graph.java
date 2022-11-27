import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://www.baeldung.com/java-graphs">Baeldung Tutorial</a>
 * two different implementations "adjacency matrix" or "adjacency list"
 * this implementations uses adjacency list
 */
public class Graph<K> {
    private Map<Vertex<K>, List<Vertex<K>>> adjVertices;
   
    
    public Graph() {
        this.adjVertices = new HashMap<>();
    }
    
    public void addVertex(K data) {
        adjVertices.putIfAbsent(new Vertex<>(data), new ArrayList<>());
    }
    
    public void removeVertex(K data) {;
        if (adjVertices.containsKey(data)) {
            adjVertices.remove(data);
        }
    }
    public static class Vertex<T> {
        T data;
        public Vertex(T data) {
            this.data = data;
        }
    
        @Override
        public int hashCode() {
            return data.hashCode();
        }
    
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            // looking to see if data is equal must handle hashing and equals in generic type data
            return obj.equals(data);
        }
    }
}
