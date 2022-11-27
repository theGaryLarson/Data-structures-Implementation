import java.util.Objects;
import java.util.UUID;

public class UniqueObject implements Comparable<UniqueObject> {
    /** unique identifier for this object */
    private UUID id;
    /** human readable identifier */
    private String label;
    
    public UniqueObject(String label) {
        id = UUID.randomUUID();
        this.label = label;
    }
    
    public UUID getId() {
        return id;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public int compareTo(UniqueObject o) {
        return id.compareTo(o.id);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if ((o.getClass() == Graph.Vertex.class)) {
//            return id.equals(((UniqueObject) o).getId());
//        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
