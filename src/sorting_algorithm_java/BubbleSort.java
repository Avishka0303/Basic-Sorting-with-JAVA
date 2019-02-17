package sorting_algorithm_java;

public class BubbleSort {
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
        for(int i=0;i<size;i++){
            System.out.println(data[i]);
        }
        //sorting algorithm
        long timeInitial=System.nanoTime();
        
        for(int pass=1;pass<size;pass++){
            for(int i=0;i<size-pass;i++){
                if(data[i]>data[i+1]){
                    int temp=data[i];
                    data[i]=data[i+1];
                    data[i+1]=temp;
                }
            }
        }
 
        long timeOut=System.nanoTime();
        //calculate the processing time.
        long processing_Time=timeOut-timeInitial;
        
        //print the result data set.
        System.out.println("\nThe result data set\n");
        for(int i=0;i<size;i++){
            System.out.println(data[i]);
        }
        System.out.println("\nProcessing time(without any threads) in ns : "+processing_Time);
    }  
}
