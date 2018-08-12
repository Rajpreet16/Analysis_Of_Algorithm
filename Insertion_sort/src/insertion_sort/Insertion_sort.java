/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertion_sort;
import java.util.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;



class InsertionSort{
    
    void sort(int arr[] , int length){
        int j;
        for( int i = 1 ; i < length; i++){
            int key = arr[i];
            for(j = i-1; j>=0 && arr[j] > key ; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
    }
}


public class Insertion_sort {

    
    public static void main(String[] args) throws FileNotFoundException {
        
//        WE STORE SYSTEM TIME IN NANO SECONDS IN VARIABLE
       long startTime = System.nanoTime();
//      Store file path containing numbers
       String fName = "C:/Users/Rajpreet Singh/Desktop/Elements.txt";
       Scanner s = new Scanner (new BufferedReader(new FileReader(fName)));   
//       First int of file will be the size of numbers you want to sort
       int n = s.nextInt();  
       int name [] = new int[n];
       int i = 0;  
//      Get all the integers in array
       while(s.hasNext())
       {
           if (s.hasNextInt()) 
           {
                name[i]=s.nextInt();  
                i++;
            }
      }
//     make object of sorting class
       InsertionSort ob = new InsertionSort();
        
//       call the method
        ob.sort(name, name.length-1);
        
        //WE STORE SYSTEM TIME IN NANO SECONDS IN VARIABLE AND SUBTRACT IT WITH INITIAL TIME 
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime/1000000000);
        
//        optional (PRINTS ALL THE ELEMENTS)
        int size = name.length;
        for (int z=0; z<size; ++z)
            System.out.print(name[z] + " ");
        System.out.println();
    }
    
}
