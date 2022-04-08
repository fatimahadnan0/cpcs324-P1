
import java.util.*;
public class kruskalAlg extends MSTAlgorithem{
    
    public  kruskalAlg(Graph graph){
      super(graph);
    }
    public void kruskal(Graph graph) {
    //start time
       long Start = System.currentTimeMillis();
    
        MSTresultList=new  LinkedList<>();
        
        PriorityQueue<edge> PQ = new PriorityQueue<>(Comparator.comparingInt(o ->o.weight));
          
        //Array to store the edge 
          edge[] parent =new edge[graph.vetices.length];
          //loop used for stored edges
          for(int i=0;i<graph.vetices.length;i++){
          parent[i]=new edge();
          }
          
        
        for(int i = 0; i <graph.vetices.length ; i++){
            for(int j =0 ;j< graph.vetices[i].adjlist.size();j++){
                PQ.add(graph.vetices[i].adjlist.get(j));
            }
        }
         
       //invoke
            makeSet(parent);
            
            
            int index =0;
         //Number of edges to be taken is equal to veticesNo-1
        while(index<graph.veticesNo -1 && !PQ.isEmpty()){
            edge edge=PQ.remove();
           //check if adding this edge creates a cycle
            int x = find(parent, edge.source.label);
            int y = find(parent, edge.target.label);
     
        if(x!=y){   
        //add to final result
        MSTresultList.add(new edge(edge.source, edge.target, edge.weight));
         union(parent, x, y); 
        }
        }
       //print cost
        DisplayResultingMST(MSTresultList) ;
        //end time
        long End = System.currentTimeMillis();
        //print time
        System.out.println("Total runtime of Kruskal's Algorithm :  " + (End - Start)+" MS \n-----------------------");
    } 
  //creat new element with parent
   public void makeSet(edge[] parent) {
        for (int i = 0; i < parent.length; i++) {
            parent[i].source=new vertex();
            parent[i].source.label = i;
 
          
        }
    }
    public int find(edge[] parent, int vertex) {
        if (parent[vertex].source.label != vertex) {
        return find(parent, parent[vertex].source.label);
        }
        return vertex;
    }
    public void union(edge[] parent, int x, int y) {
        int xp = find(parent, x);
        int yp = find(parent, y);
        //make x as parent of y
        parent[yp].source.label = xp;
    } 

   
    public void DisplayResultingMST(LinkedList<edge> MSTresultList){
        int cost=0;
   for (int i = 0; i < MSTresultList.size(); i++) {
	edge edge = MSTresultList.get(i);
	cost += edge.weight;
    }
        System.out.println("Minimum Spanning Tree Cost to kruskal's algorithm : "+cost);
    
    	
}}

