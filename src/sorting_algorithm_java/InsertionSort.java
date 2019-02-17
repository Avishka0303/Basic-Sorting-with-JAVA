package sorting_algorithm_java;

public class InsertionSort {
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
        for(int i=0;i<size;i++){
            for(int j=i;j>0;j--){
                if(data[j-1]>data[j]){
                    int temp=data[j];
                    data[j]=data[j-1];
                    data[j-1]=temp;
                }
            }
        }
        long timeOut=System.nanoTime();
        long processing_Time=timeOut-timeInitial;
        
        //print the result data set.
        System.out.println("\nThe result data set\n");
        for(int i=0;i<size;i++){
            System.out.println(data[i]);
        }
        System.out.println("\nProcessing time(without any threads) in ns : "+processing_Time);
    }  
}
