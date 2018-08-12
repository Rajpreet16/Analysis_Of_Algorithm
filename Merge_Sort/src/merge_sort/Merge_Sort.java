
package merge_sort;
import java.util.*;
import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class MergeSort{
 
    void merge(int arr[], int low_index, int mid_index, int high_index){
    
    int size_of_array_1 = mid_index - low_index +1;
    int size_of_array_2 = high_index - mid_index;
    
    int L[] = new int[size_of_array_1];
    int R[] = new int[size_of_array_2];
    
    
    for(int i = 0 ; i < size_of_array_1 ; i++)
        L[i] =  arr[ low_index + i];
    
    for(int j = 0 ; j < size_of_array_2 ; j++)
        R[j] =  arr[ mid_index + 1 +j ];
    
    int i = 0;
    int j = 0;
    int k = low_index;
    
    while(i < size_of_array_1 && j < size_of_array_2){
        
        if(L[i] <= R[j])
        {
            arr[k] = L[i];
            i++;
        }
        else
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    
    while(i < size_of_array_1){
        arr[k] = L[i];
        i++;
        k++;
    }
    
    while(j < size_of_array_2){
        arr[k] = R[j];
        j++;
        k++;
    }
    
    }
    
    
    
    
    
    
    void sort(int arr[], int i, int j){
        if(i<j){
            
            int mid = (i+j)/2;
            
            sort(arr,i,mid);
            sort(arr,mid+1,j);
            merge(arr,i,mid,j);
        }
    }
}

public class Merge_Sort {
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
       MergeSort ob = new MergeSort();
//       call the method
        ob.sort(name, 0, name.length-1);
        
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
