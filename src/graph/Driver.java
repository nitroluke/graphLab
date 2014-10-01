package graph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.math.*;
//C:\Users\nitroluke\Documents\NetBeansProjects\Tree\src\Driver.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nitroluke
 */
public class Driver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        int arrLength = 6;
        int x = 0;
        int y = 0;
        int start = 0;  // which node do you want to start to search from

        char value;
        // TODO code application logic here
        Scanner in = new Scanner(new FileReader("C://Users/nitroluke/Documents/NetBeansProjects/Graph/AdjacencyMatrix.txt"));
        int adjacencyMatrix[][] = new int[arrLength][arrLength];

        while (in.hasNext()) {
            String string = in.next();
            for (int i = 0; i < string.length(); i++) {
                if (y > arrLength - 1 ) { // go to the next line reset y, and increment x.
                    x++;
                    y = 0;
                }
                value = string.charAt(i);
                switch (value) {  // doing this becuase it was still using the ASCII values every after the type cast.
                    case 48:
                        adjacencyMatrix[x][y] = 0;
//                        bRepresentation[x][y] = false;
                        break;
                    case 49:
                        adjacencyMatrix[x][y] = 1;
//                        bRepresentation[x][y] = true;
                        break;
                    default:
                        System.out.println("This should never happen");
                        return;
                }
                y++;
            }

//            System.out.println("y = " + y + " x = " + x);
        }
        Scanner in2 = new Scanner(new FileReader("C://Users/nitroluke/Documents/NetBeansProjects/Graph/WeightedMatrix.txt"));
        int weightedMatrix[][] = new int[arrLength][arrLength];
        int weight = 0;
        x = 0;
        y = 0;
        while(in2.hasNext()){
            for(int i = 0; i < arrLength; i++){
                weight = in2.nextInt();
                System.out.println("weight =  " + weight);
                if(y > arrLength-1){
                x++;
                y = 0;
                }
                switch(weight){
                    case(-99):
                        weightedMatrix[x][y] = Integer.MAX_VALUE;
                        break;
                        
                    default:
                        weightedMatrix[x][y] = weight;
                }
                y++;
            }
        }
        
        Graph g = new Graph(adjacencyMatrix, weightedMatrix);

        System.out.println("\nDoing Breadth First Search starting at " + start);
        System.out.println("---------------------------------------\n");
        g.BFS(start);
        System.out.println("\nFinished Breadth First Search");
        System.out.println("_______________________________________\n");

        System.out.println("\nDoing Depth First Search starting at 0");
        System.out.println("---------------------------------------\n");
        g.DFS(start);
        System.out.println("\nFinished Breadth First Search");
        System.out.println("_______________________________________\n");
        
        System.out.println("The Adjacency Matrix\n");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j]);

            }
            System.out.println("");
        }
        
        System.out.println("\nThe Weighted Matrix\n");
        for (int i = 0; i < weightedMatrix.length; i++) {
            for (int j = 0; j < weightedMatrix.length; j++) {
                System.out.print(weightedMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
