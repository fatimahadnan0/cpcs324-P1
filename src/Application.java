 import java.util.*;
public class Application {
    
   static Scanner input=new Scanner(System.in);
 public static void main(String [] args){  
     
 
      System.out.println("\t ------------Minimum Spanning Tree Algorithms-----------\n");
      System.out.println("\t1- Kruskal's Algorithm& Priority Queue based Prim Algorithem\n"
                + "\t2- Min Heap bease on Prim Algorithm & Prim's Algorithm(based on Priority Queue)");
      
      System.out.print(">>> Enter your choice (1 or 2) : ");
        int comparison = input.nextInt();
        
        System.out.println(">>> n is the number of vertices) and (m is the number of edges) : ");
        System.out.println(" 1:  n=1,000 ,  m=10,000");
        System.out.println(" 2:  n=1,000 ,  m=15,000");
        System.out.println(" 3:  n=1,000 ,  m=25,000");
        System.out.println(" 4:  n=5,000 ,  m=15,000");
        System.out.println(" 5:  n=5,000 ,  m=25,000");
        System.out.println(" 6:  n=10,000 , m=15,000");
        System.out.println(" 7:  n=10,000 , m=25,000");
        System.out.println(" 8:  n=20,000 , m=200,000");
        System.out.println(" 9:  n=20,000 , m=300,000");
        System.out.println("10:  n=50,000 , m=1,000,000");
        System.out.print(">>> Enter a case to test : ");
        int Case = input.nextInt();

        switch (Case) {
            case 1:
                //graph(4, 5, comparison);
                graph(1000, 10000, comparison);
                break;
            case 2:
                graph(1000, 15000, comparison);
                break;
            case 3:
                graph(1000, 25000, comparison);
                break;
            case 4:
                graph(5000, 15000, comparison);
                break;
            case 5:
                graph(5000, 25000, comparison);
                break;
            case 6:
                graph(10000, 15000, comparison);
                break;
            case 7:
                graph(10000, 25000, comparison);
                break;
            case 8:
                graph(20000, 200000, comparison);
                break;
            case 9:
                graph(20000, 300000, comparison);
                break;
            case 10:
                graph(50000, 1000000, comparison);
                break;
            default:
                System.out.println("---Invalid input!---");
                break;
        }

    }
     

public static void graph(int verteces,int edge,int comparison ){
    for (int n=1;n<11;n++){
        System.out.println("-------------------------("+n+")---------------------------");
     Graph graph=new Graph(verteces, edge,false);
    graph.make_graph();
 
    kruskalAlg K=new kruskalAlg(graph);

    PQPrimAlg P=new PQPrimAlg(graph);

//     MHPrimAlg mh=new MHPrimAlg(graph);
     MHPrimAlg MH=new MHPrimAlg(graph);
     
   switch (comparison) {
            case 1:
                K.kruskal(graph);
                P.PQ(graph);
                 break;
            case 2:
              P.PQ(graph);
                MH.MH(graph);
                break;
            default:
                System.out.println("---Invalid input!---");
                break;
        }
        
}}}
