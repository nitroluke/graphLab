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
        int value;
        // TODO code application logic here
        Scanner in = new Scanner(new FileReader("C://Users/nitroluke/Desktop/AdjacencyMatrix.txt"));
//        in.useDelimiter("");
        int adjacencyMatrix[][] = new int[5][5];
        while(in.hasNext()){
            System.out.print("");
            
//            System.out.print(in.next());
//            System.out.println("We get here");
            String string = in.next();
            for(int i = 0; i < string.length(); i++){
                if (y > 4){
                x++;
                y = 0; 
                }
                value = string.charAt(i);
                adjacencyMatrix[x][y] = (int)value;
                y++;
            }
            
            
//            System.out.println("y = " + y + " x = " + x);
        }
    }
}
