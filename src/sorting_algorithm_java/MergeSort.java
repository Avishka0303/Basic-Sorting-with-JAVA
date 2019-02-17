package sorting_algorithm_java;

public class MergeSort {

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
        
        int low=0;
        int high=9;
        
        //calculate the time for whole processing.
        long timeInitial=System.nanoTime();
        mergeSort(data,low,high);
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
    
    /*
    this is a recursive method.
    1.whole array divides into seperate elments and merge them by comparing the adgacent element.
    */
    public static void mergeSort(int arr[],int low,int high){
        int size=arr.length;
        if(low<high){
            int middle=(low+high)/2;
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }
    
    public static void merge(int arr[],int low,int middle,int high){
        int size=arr.length;
        int [] temp=new int[size];
        for(int i=low;i<=high;i++){
            temp[i]=arr[i];
        }
        int i=low;
        int j=middle+1;
        int k=low;
        
        while(i<=middle && j<=high){
            if(temp[i] <= temp[j]){
                arr[k]=temp[i];
                i++;
            }else{
                arr[k]=temp[j];
                ++j;
            }
            ++k;
        }  
        
        while(i<=middle){
            arr[k]=temp[i];
            ++k;
            ++i;
        }
    }
}
