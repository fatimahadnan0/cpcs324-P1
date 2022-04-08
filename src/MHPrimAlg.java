

import java.util.*;


public class MHPrimAlg extends MSTAlgorithem {
      int cost;
    public MHPrimAlg(Graph graph){
      super(graph);
    }

   

    @Override
    public void DisplayResultingMST(LinkedList<edge> MSTresultList) {
         
           System.out.println("Minimum Spanning Tree Cost to Min Heap : " +cost);
    }
       
 public void MH(Graph graph) {
          
          //start time
          long start = System.currentTimeMillis();
          
          int vertices=graph.veticesNo;
          
         // edge edge=new edge();
            
            MSTresultList = new LinkedList<>();
            
             PriorityQueue<edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

             boolean[] inHeap = new boolean[vertices];
                        
            edge[] parent = new edge[vertices];
            
            // used to store the key to know whether min hea update is required
            int[] key = new int[vertices];
            
            //create heapNode for all the vertices
            HeapNode[] heapNode = new HeapNode[vertices];
            
            MinHeap minheap = new MinHeap(vertices);
            
            for (int i = 0; i < vertices; i++) {
                heapNode[i] = new HeapNode();
                heapNode[i].vertex = i;
                heapNode[i].key = Integer.MAX_VALUE;
                parent[i] = new edge();
                parent[i].parent=new vertex();
                parent[i].parent.label= -1;
                inHeap[i] = true;
                key[i] = Integer.MAX_VALUE;
            }

            //decrese key in first index
            heapNode[0].key = 0;

            for (int i = 0; i < vertices; i++) {
                minheap.insert(heapNode[i]);
            }
            
            while (!minheap.isEmpty()) {
                
                HeapNode node = minheap.MIN();
                
                int Vertex = node.vertex;
                
                inHeap[Vertex] = false;

		
		 for(int i = 0 ; i < graph.vetices[Vertex].adjlist.size() ; i++)
                {
                   edge edge = graph.vetices[Vertex].adjlist.get(i);
                   // int e = edge.target.label;
                  // cost +=edge.weight;
                      pq.add(edge);
                     
                    if (inHeap[edge.target.label]) {
                        int destination = edge.target.label;
                        int newKey = edge.weight;
                        
                        
                        if (key[destination] > newKey) {
                            decreaseKey(minheap, newKey, destination);
                           
                            parent[destination].parent.label = Vertex;
                            parent[destination].weight = newKey;
                            key[destination] = newKey;
                        }
                    }
                }
            }
      
           
           for(int i=1;i<graph.veticesNo;i++){
               cost+= parent[i].weight;
           }
           DisplayResultingMST(MSTresultList);
            //end time
             long finsh = System.currentTimeMillis();
        //print time
        System.out.println("Total runtime of Min Heap Algorithm : " + (finsh - start) + " MS \n-----------------------");
        }



        public void decreaseKey(MinHeap minheap, int key, int vertex) {

            int n = minheap.decreaseKay[vertex];

            HeapNode node = minheap.heapnode[n];
            node.key = key;
            minheap.bubbleUp(n);
        }
 static class HeapNode {

        int vertex;
        int key;
    }
   
 static class MinHeap {

        int capacity;
        int Csize;
        HeapNode[] heapnode;
        int[] decreaseKay; //will be used to decrease the key

        public MinHeap(int capacity) {
            this.capacity = capacity;
            heapnode = new HeapNode[capacity + 1];
            decreaseKay = new int[capacity];
            heapnode[0] = new HeapNode();
            heapnode[0].key = Integer.MIN_VALUE;
            heapnode[0].vertex = -1;
            Csize = 0;
        }

        public void insert(HeapNode heap) {
            Csize++;
            int i = Csize;
            heapnode[i] = heap;
            decreaseKay[heap.vertex] =i ;
            bubbleUp(i);
        }

        public void bubbleUp(int i) {
            int parentI = i / 2;
            int currentI = i;
            while (currentI > 0 && heapnode[parentI].key > heapnode[currentI].key) {
                HeapNode CNode = heapnode[currentI];
                HeapNode PNode = heapnode[parentI];

                //swap the positions
                decreaseKay[CNode.vertex] = parentI;
                decreaseKay[PNode.vertex] = currentI;
                swap(currentI, parentI);
                currentI = parentI;
                parentI = parentI / 2;
            }
        }

        public HeapNode MIN() {
            HeapNode Min_Node = heapnode[1];
            HeapNode Last_Node = heapnode[Csize];
//            update the indexes[] and move the last node to the top
            decreaseKay[Last_Node.vertex] = 1;
            heapnode[1] = Last_Node;
            heapnode[Csize] = null;
            Down(1);
            Csize--;
            return Min_Node;
        }

        public void Down(int x) {
            int small = x;
            int Lift = 2 * x;
            int Right = 2 * x + 1;
            if (Lift < heapSize() && heapnode[small].key > heapnode[Lift].key) {
                small = Lift;
            }
            if (Right < heapSize() && heapnode[small].key > heapnode[Right].key) {
                small = Right;
            }
            if (small != x) {

                HeapNode Smallest_Node = heapnode[small];
                HeapNode Node = heapnode[x];

                //swap the positions
                decreaseKay[Smallest_Node.vertex] = x;
                decreaseKay[Node.vertex] = small;
                swap(x, small);
                Down(small);
            }
        }

        public void swap(int x, int y) {
            HeapNode temp = heapnode[x];
            heapnode[x] = heapnode[y];
            heapnode[y] = temp;
        }

        public boolean isEmpty() {
            return Csize == 0;
        }

        public int heapSize() {
            return Csize;
        }
    }

    
}
