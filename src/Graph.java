
import java.util.Random;

/**
 *
 * @author fatimah
 */
public class Graph{

    /**
     *
     */
    int veticesNo;

    /**
     *
     */
    int edgeNo;

    /**
     *
     */
    boolean isDigraph=false;

    /**
     *
     */
    vertex[] vetices;

    /**
     *
     * @param veticesNo
     * @param edgess
     * @param isDigraph
     */
    public Graph(int veticesNo, int edgess,boolean isDigraph) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgess;
        this.isDigraph = isDigraph;
        this.vetices=new vertex[veticesNo];
        for (int i = 0; i < veticesNo; i++) {
            vetices[i] = new vertex(i);}}
  
//to add new edge to the geaph

    /**
     *
     * @param source
     * @param target
     * @param weight
     */
 public void addEdge(vertex source, vertex target, int weight) {
        edge edge = new edge(source, target, weight);
        source.adjlist.addFirst(edge);
       if (!isDigraph) {
          edge = new edge(target, source, weight);
         target.adjlist.addFirst(edge);} }
 
    /**
     *
     */
    public void make_graph() {
     //random class
        Random random = new Random();
        //cheak that all vertices are connectet
        for (int i = 0; i < veticesNo - 1; i++) {
            int RandomNum = random.nextInt(20) + 1;
            addEdge(vetices[i], vetices[i + 1], RandomNum);}
        
        //remaning edge 
        int remaning = edgeNo - (veticesNo - 1);

        for (int i = 0; i < remaning; i++) {
             vertex source = vetices[random.nextInt(veticesNo)];
             vertex Destination = vetices[random.nextInt(veticesNo)];
             
             int weight = random.nextInt(20) + 1;
             // to avoid duplicate edges
            if (source==Destination || isConnected(source, Destination)) { 
               i--;
            }
            else{
                //add edge to graph
            addEdge(source, Destination, weight);}
        }
    }
 //check if the edge is exist and connect

    /**
     *
     * @param Source
     * @param target
     * @return
     */
 public boolean isConnected(vertex Source, vertex target) {
        for (edge edge : Source.adjlist) {         
                if (edge.target == target) {
                    return true;}}
        return false;
    }
 
//  public void print() {
//        System.out.println("Graph => " + veticesNo + " verticies and " + edgeNo + " edges");
//        for (vertex vertex : vetices) {
//            for (edge edge : vertex.adjlist) {
//                System.out.println(edge.source.label + "--" + edge.target.label + "-- weight "+edge.weight);
//            }
//        }
//}
}
