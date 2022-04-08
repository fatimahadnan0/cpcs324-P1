
import java.util.*;

public class PQPrimAlg extends MSTAlgorithem {
    
     int cost;
     
    public PQPrimAlg(Graph graph) {
       
    super(graph);
    }

    public void PQ(Graph graph) {
        
        //start time
        long Start = System.currentTimeMillis();
        
        MSTresultList = new LinkedList<>();
     
        PriorityQueue<edge> PQ = new PriorityQueue<>(Comparator.comparingInt(o ->o.weight));
        
        //add vetices 
        add(PQ,graph.vetices[0]);
     
        while (!PQ.isEmpty()) {
            edge edge = PQ.poll();
            //check not add vertices visited vertices
            if (edge.target.isVisited) {
                continue;
            }
            //to calculate cost
            cost += edge.weight;
           
            MSTresultList.add(new edge(edge.source,edge.target,edge.weight ));
            
            add(PQ,edge.target);
        }
        //prent cost
        DisplayResultingMST(MSTresultList);
        //end time
        long End = System.currentTimeMillis();
        //print time
        System.out.println("Total runtime of Priority queue's Algorithm : " + (End - Start) + " MS \n-----------------------");
        
    }

    //add all connected edges with vertex
    public void add(PriorityQueue pq,vertex source) {
        source.isVisited = true;
        for (edge edge : source.adjlist) {
            if (graph.vetices[edge.target.label].isVisited==false) {
                pq.add(edge);
            }
        }
    }
 
    @Override
    public void DisplayResultingMST(LinkedList<edge> MSTresultList) {
        System.out.println("Minimum Spanning Tree Cost to Priority queue : " + cost);
   }
}
