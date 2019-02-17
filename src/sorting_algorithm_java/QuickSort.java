package sorting_algorithm_java;

/*
this is also and divide and conquor algorithm
*/

public class QuickSort {
    
    public static void main(String[] args) {
        
        //creating  array for random numbers.
        int size=10;
        int data[]=new int[size];
        
        //initializing array with random numbers
        for(int i=0;i<size;i++){
            data[i]=(int)(Math.random()*100);
        }
        
        //print the random data set.
        System.out.println("Data elements before sorting.\n");
        displayArray(data);
        
        // call to sorting algorithm and start time counting.
        long timeInitial=System.nanoTime();
        
        quickSort(data,0,data.length-1);
 
        long timeOut=System.nanoTime();

        //calculate the processing time.
        long processing_Time=timeOut-timeInitial;
        //print the result data set.
        System.out.println("\nThe result data set\n");
        displayArray(data);
        System.out.println("\nProcessing time(without any threads) in ns : "+processing_Time);
        
    } 
    
    public static void displayArray(int data[]){
        int size=data.length;
        for(int i=0;i<size;i++){
            System.out.println(data[i]);
        }
    }
    
    //quick sort algorithm
    public static void quickSort(int arr[],int left,int right){
        int i=left;
        int j=right;
        int temp;
        int pivot=arr[(left+right)/2];
        
        while(i<=j){
            
            while(arr[i]<pivot) i++;
            while(arr[j]>pivot) j--;
            
            if(i<=j){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }      
        }
        if(left<j) quickSort(arr,left,j);
        if(i<right) quickSort(arr,i,right);
    }
}
