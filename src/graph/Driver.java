package graph;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
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
     */
    public static void main(String[] args) throws FileNotFoundException {
        int x = 0; 
        int y = 0;
        char value;
        // TODO code application logic here
        Scanner in = new Scanner(new FileReader("C://Users/nitroluke/Desktop/AdjacencyMatrix.txt"));
//        in.useDelimiter("");
        int adjacencyMatrix[][] = new int[5][5];
        while(in.hasNext()){
//            System.out.print("");
            String string = in.next();
            for(int i = 0; i < string.length(); i++){
                if (y > 4){ // go to the next line reset y, and increment x.
                x++;
                y = 0; 
                }
                value = string.charAt(i);
                switch(value){  // doing this becuase it was still using the ASCII values every after the type cast.
                    case 48: adjacencyMatrix[x][y] = 0;
                        break;
                    case 49: adjacencyMatrix[x][y] = 1;
                        break;
                    default:
                        System.out.println("This should never happen");
                        return;
                }
                y++;
            }
            
            
//            System.out.println("y = " + y + " x = " + x);
        }
        for(int i = 0; i < 5; i ++){
            for (int j = 0; j < 5; j++){
                System.out.print(adjacencyMatrix[i][j] + "|");
            }
            System.out.println("");
        }
    }
}
