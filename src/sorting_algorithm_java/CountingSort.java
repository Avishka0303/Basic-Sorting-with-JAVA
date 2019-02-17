package sorting_algorithm_java;

//this is only for positive numbers.
public class CountingSort {
    
    public static void main(String[] args) {
        //initialize an array.
        int data[]={2,8,6,9,4,7,6,2,5,1};
        int dataLength=data.length;
        displayArray(data);
        
        //sorting algorithm
        long timeInitial=System.nanoTime();
        countingSort(data);
        long timeOut=System.nanoTime();
        
        //calculate the processing time.
        long processing_Time=timeOut-timeInitial;
        
        //print the result data set.
        System.out.println("\nThe result data set\n");
        displayArray(data);
        System.out.println("\nProcessing time(without any threads) in ns : "+processing_Time);   
    }
    
    public static void countingSort(int data[]){
        
        int elements=data.length;
        int output[]=new int[elements];
        
        //counter array for store count of individual
        int count[]=new int[10];
        //initialize as 0
        for(int i=0;i<count.length;i++) count[i]=0;
        
        //bucketing the values.
        for(int i=0;i<elements;i++)
            ++count[data[i]];
        
        //find for actual position
        for(int i=1;i<count.length;i++)
            count[i]+=count[i-1];
        
        //rearrange an output array for print.
        for (int i = elements-1; i>=0; i--) { 
            output[count[data[i]]-1] = data[i]; 
            --count[data[i]]; 
        }
        
        //copy to the original array.
        for(int i=0;i<elements;i++)
            data[i]=output[i];
    }
    
    public static void displayArray(int data[]){
        int size=data.length;
        for(int i=0;i<size;i++){
            System.out.println(data[i]);
        }
    }
    
}
