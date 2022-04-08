
import java.util.*;

abstract class MSTAlgorithem extends  Application{
    
    Graph graph;
    LinkedList<edge> MSTresultList = new LinkedList<>();
    
    public MSTAlgorithem(Graph graph) {
        this.graph = graph;

}
public abstract void DisplayResultingMST(LinkedList<edge> MSTresultList);
    
}


