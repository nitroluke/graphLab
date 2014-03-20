/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.math.*;

/**
 *
 * @author nitroluke
 */
public class Graph {

    private int adjMatrix[][];
    private int weightedMat[][];

    public Graph(int adjMatrix[][], int weightedMat[][]) {
        this.adjMatrix = adjMatrix;
        this.weightedMat = weightedMat;
    }

    public void BFS(int start) {  // do this using a queue
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length * adjMatrix.length];

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.println("The current node we are at is " + current);
            for (int y = 0; y < adjMatrix.length; y++) {
                if (adjMatrix[current][y] == 1 && !visited[y]) {
                    queue.offer(y);
                    visited[y] = true;
                    System.out.println("Adding node " + y + " to the queue");
                }

            }
            System.out.println("Done processing node " + current);
        }
    }

    private void DFS(int current, boolean visited[]) {
        System.out.println("The current node we are at is " + current);
        visited[current] = true;

        for (int y = 0; y < adjMatrix.length; y++) {
            if (adjMatrix[current][y] == 1 && !visited[y]) {
                System.out.println("Going to Node " + y);
                DFS(y, visited);
            }
        }
        System.out.println("Done processing node " + current + " Bitch!");
    }
    
    public void DFS(int start){
    boolean visitedArr[] = new boolean[adjMatrix.length];

        DFS(start, visitedArr);
    }
    
    private void Dijkstra(int start, int end){
    Queue<Integer> queue = new LinkedList<>();

        
    }
    
//    private void Prim(int weightedMat[][]){
//        //int[] source = new int[weightedMat.length];
//        double[] distance = new double[weightedMat.length];
//        boolean[] nodeVisited = new boolean[weightedMat.length];
//        
//        for(int i = 0; i < weightedMat.length; i++){
//            nodeVisited[i] = false; // set all the nodesvisited to false
//            distance[i] = Double.POSITIVE_INFINITY; //set all the distances to infinity
//        }
//        nodeVisited[0] = true; // start at 0
//        distance[0] = 0;
//        int closestNode = 0;
//        double smallestDist;
//        
//        for(int i = 0; i < weightedMat.length; i++){
//            smallestDist = Double.POSITIVE_INFINITY;
//            for(int j = 0; j < weightedMat.length; j++){
//                if(!nodeVisited[j]){
//                    double weight = 
//                }
//            }
//        }
//    }
    
    private void Prim(){
        // innitialize S with the start verted s, and V-S with the remaining vertices.
        for(int i = 0; i < weightedMat.length; i++){
            //p[v] = s // start = 0
            if(weightedMat[0][i] != 0){
                //set d[v] = w(s,v);
            }else{
                //dv = Double.POSITIVE_INFINITY;
            }
            while(){ //V-S is not empty
                for(){// all u in V-S, find the smallest d[u]
                    //remove the smallest u from V-S and add it to S
                    //inset the edge (u,p[u]) into the spanning tree
                    for(){ //all v is V-S
                        if(){ // w(u,v) < d[v]
                            //set d[v] to w(u,v)
                            //set p[v] to u
                        }
                    }
                }
            }
        }
    }
    private void Floyd(){
        
    }
    
    private void FloydWarsall(int path[][]){
        for(int i = 0; i < path.length; i++){
            for(int j = 0; j < path.length; j++){
                for(int k = 0; k <path.length; k++){
                    path[i][j] = Math.min(path[i][j], path[i][k] + path[k][j]);
                }
            }
        }
    }
}
