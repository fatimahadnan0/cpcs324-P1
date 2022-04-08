/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mada7
// */
public class edge implements Comparable<edge> {
 int weight;
 vertex source;
 vertex target; 

 vertex parent;
 
    
 public edge(){
 
 }
 public edge(vertex source, vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.parent=source;
    }

    public int compareTo(edge other) {
        return weight - other.weight;
    }
@Override
 public String toString() {
        return source + "-" + target + ": w =" + weight;
    }

    

}


