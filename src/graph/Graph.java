/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.math.*;
import java.util.Arrays;
import java.util.PriorityQueue;

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
    
//    public void Dijkstra(int n, int startV){
//    PriorityQueue<Integer> queue = new PriorityQueue<>();
//    Queue<Integer> path = new LinkedList<>();
//    int weightToStart[] = new int[weightedMat.length];
//    boolean visited[] = new boolean[weightedMat.length];
//    int curNode = startV;
//    
//    // need something to hold the things you will travel to queue should work
//    boolean visitedFlag = isVisited(visited);
//    Arrays.fill(weightToStart, Integer.MAX_VALUE);
//    path.add(startV);
//    while(!visitedFlag){ // while all the nodes have not been visited
//        for(int i = 0; i < weightedMat.length; i++){
//            if(weightedMat[curNode][i] != 0){
//                queue.offer(weightedMat[curNode][i]);
//            }
//        }
//        for(int i = 0; i < weightedMat.length; i++){
//            if(queue.peek() == weightedMat[curNode][i]){
//                visited[i] = true;
//                curNode = i;
//                path.add(i);
//                if(weightToStart[i] < weightedMat[curNode][i]){
//                weightToStart[i] += weightedMat[curNode][i];
//                }
//                break;
//            }
//        }
//        
//        
//    }
//    }
    
    public void Dijkstra(int start){
        int weight[] = new int[weightedMat.length];
        boolean visited[] = new boolean[weightedMat.length];
        for(int i = 0; i < weightedMat.length; i++){
            weight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        weight[start] = 0;
        for(int count = 0; count < (weightedMat.length - 1); count++){
            int minVertex = returnMinDist(weight,visited);
            visited[minVertex] = true;
            for(int j = 0; j < weightedMat.length; j++){
                if(!visited[j] && weightedMat[minVertex][j] != Integer.MAX_VALUE && weight[minVertex] != Integer.MAX_VALUE 
                               && weight[minVertex] + weightedMat[minVertex][j] < weight[j]){
                    weight[j] = weight[minVertex] + weightedMat[minVertex][j];
                }
            }
        }
        printPath(weight, start);
    }
    
    void Prims(int startNode){
        int MST[] = new int[weightedMat.length];
        int weight[] = new int[weightedMat.length];
        boolean visited[] = new boolean[weightedMat.length];
        
        for(int i = 0; i < weightedMat.length; i++){
            weight[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        weight[0] = 0;
        MST[0] = startNode;
        for(int count = 0; count<weightedMat.length;count++){
            int minVertex = returnMinDist(weight,visited);
            visited[minVertex] = true;
            for(int j = 0; j < weightedMat.length; j++){
                if(weightedMat[minVertex][j] != 0 && !visited[j] && weightedMat[minVertex][j] < weight[j]){
                    MST[j] = minVertex;
                    weight[j] = weightedMat[minVertex][j];
                }
            }   
        }
        printMST(MST);
    }
    
    private void printMST(int MST[]){
        for(int i=0; i<weightedMat.length;i++){
            System.out.println("Edge :" + MST[i] + "-"+ i + " = " + weightedMat[i][MST[i]]);
        }
    }
    private void printPath(int weight[], int start){
        for(int i = 0; i < weightedMat.length; i++){
            System.out.println(" Shortest distance from starting node: " + start + " To vertex: " + i + " = " + weight[i]);
        }
    }
    private int returnMinDist(int weight[],boolean visited[]){
        int min = Integer.MAX_VALUE;
        int minPosition = 0;
        
        for(int v = 0; v < weightedMat.length;v++){
            if(visited[v] == false && weight[v] <= min){
                min = weight[v];
                minPosition = v;
            }
            
        }
        return minPosition;
        
    }
     private boolean isVisited(boolean visited[]) {
        boolean temp = false;
    for(int i = 0; i < visited.length;i++){
        if(visited[i] == true){ // if a node has been visited, it will be set to true;
            temp = true;
        }
        else{
            return false;
        }
    }
    return temp;
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
//            while(){ //V-S is not empty
//                for(){// all u in V-S, find the smallest d[u]
//                    //remove the smallest u from V-S and add it to S
//                    //inset the edge (u,p[u]) into the spanning tree
//                    for(){ //all v is V-S
//                        if(){ // w(u,v) < d[v]
//                            //set d[v] to w(u,v)
//                            //set p[v] to u
//                        }
//                    }
//                }
//            }
        }
    }
    private void Floyd(int directed[][]){
        for(int i = 0; i < directed.length; i++){
            for(int j = 0; j < directed.length; j++){
                for(int k = 0; k <directed.length; k++){
                 if (directed[i][j] > directed[i][k] + directed[k][j]){
                     directed[i][j] = directed[i][k] & directed[k][j];
                 }
                    //
                }
            }
        }
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
