import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    Graph<UniqueObject> graph = new Graph<>();
    UniqueObject u;
    
    @Test
    void addVertex() {
        ;
        
    }
    
    @Test
    void removeVertex() {
        UniqueObject u = new UniqueObject("one") ;
        graph.addVertex(u);
        graph.removeVertex(u);
    }
}