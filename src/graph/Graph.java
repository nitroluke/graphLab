/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nitroluke
 */
public class Graph {

    private int adjMatrix[][];

    public Graph(int adjMatrix[][]) {
        this.adjMatrix = adjMatrix;
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
}
