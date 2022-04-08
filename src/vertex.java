
import java.util.LinkedList;
 
public class vertex {
    
    int label;       
    boolean isVisited;
    LinkedList<edge> adjlist;
    
    public vertex(){}
    
   
    public vertex(int label){
    this.label=label;
    adjlist=new LinkedList<>();
    }
 
}