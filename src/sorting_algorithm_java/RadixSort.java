package sorting_algorithm_java;

import java.util.*; 
// Radix sort Java implementation 
class Radix { 
  
    // A utility function to get maximum value in data[] 
    static int getMax(int data[], int n) 
    { 
        int max = data[0]; 
        for (int i = 1; i < n; i++) 
            if (data[i] > max) 
                max = data[i]; 
        return max; 
    } 
  
    // A function to do counting sort of data[] according to 
    // the digit represented by exp. 
    static void countSort(int data[], int n, int exp) { 
        int output[] = new int[n]; // output array 
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count,0); 
  
        // Store count of occurrences in count[] 
        for (i = 0; i < n; i++) 
            count[ (data[i]/exp)%10 ]++; 
  
        // Change count[i] so that count[i] now contains 
        // actual position of this digit in output[] 
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // Build the output array 
        for (i = n - 1; i >= 0; i--) 
        { 
            output[count[ (data[i]/exp)%10 ] - 1] = data[i]; 
            count[ (data[i]/exp)%10 ]--; 
        } 
  
        // Copy the output array to data[], so that data[] now 
        // contains sorted numbers according to curent digit 
        for (i = 0; i < n; i++) 
            data[i] = output[i]; 
    } 
  
    // The main function to that sorts data[] of size n using 
    // Radix Sort 
    static void radixsort(int data[], int n){ 
        // Find the maximum number to know number of digits 
        int max = getMax(data, n); 
  
        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        for (int exp = 1; max/exp > 0; exp *= 10) 
            countSort(data, n, exp); 
    } 
  
    // A utility function to print an array 
    static void print(int data[], int n){ 
        for (int i=0; i<n; i++) 
            System.out.print(data[i]+" "); 
    } 
  
    /*Driver function to check for above function*/
    public static void main (String[] args) { 
        
        int data[] = {170, 45, 75, 90, 802, 24, 2, 66}; 
        int n = data.length; 
        
        //print the random data set.
        System.out.println("Data elements before sorting.\n");
        print(data,n);
        
        // call to sorting algorithm and start time counting.
        long timeInitial=System.nanoTime();
        radixsort(data, n); 
        long timeOut=System.nanoTime();

        //calculate the processing time.
        long processing_Time=timeOut-timeInitial;
        
        //print the result data set.
        System.out.println("\nThe result data set\n");
        print(data,n);
        System.out.println("\nProcessing time(without any threads) in ns : "+processing_Time);
    } 
} 