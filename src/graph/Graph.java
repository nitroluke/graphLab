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
    
    private void Prim(int weightedMat[]){
        int[] source = new int[weightedMat.length];
        double[] distance = new double[weightedMat.length];
        boolean[] nodeVisited = new boolean[weightedMat.length];
        
        for(int i = 0; i < weightedMat.length; i++){
            nodeVisited[i] = false;
            distance[i] = Double.POSITIVE_INFINITY;
        }
        nodeVisited[0] = true;
        distance[0] = 0;
        int closestNode = 0;
        double smallestDist;
        
        for(int i = 0; i < weightedMat.length; i++){
            smallestDist = Double.POSITIVE_INFINITY;
            for(int j = 0; j < weightedMat.length; j++){
                if(!nodeVisited[j]){
                    double weight = 
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
