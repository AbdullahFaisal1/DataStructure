package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        insertionSort2(input);
        
        for(int i=0; i< input.length; i++)
            System.out.print(input[i] + ", ");
        System.out.println("\n");    
        
    }

    public static void insertionSort(int array[]){
        for(int i=1; i < array.length; i++){
            int temp = array[i];

            //slide element down to make room for array[i]
            int j = i;
            while(j > 0 && array[j-1] > temp){ //  ( بجعل الأراي الحالي يخطو خطوة للخلف) مقارنة بين الأراي الحالي والي قبل، اذا كان (الي قبل) اكبر من (الحالي) فتخطاه
                //تخطى
                array[j] = array[j- 1]; // خطوة للخلف
                j--;
            }
            array[j] = temp;
        }
    }
    public static void insertionSort2(int array[]){
        int temp;
        for(int i = 1; i< array.length; i++){
            for(int j=i; j>0; j--){
                if(array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
                else
                    break;
            }
        }
    }
    // best case: if sorted O(n)
    // worst caseL O(n^2)


    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 1; i < array.length - i; j++){
                //swap addjacent out-of-order elements
                if(array[j-1] > array[j]){
                    
                }
            }
        }
    }
}
