package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        bubbleSort2(input);
        
        for(int i=0; i< input.length; i++)
            System.out.print(input[i] + ", ");
        System.out.println("\n");    
        
    }

    public static void bubbleSort(int[] array){ // not completed
        for(int i = 0; i < array.length; i++){
            for(int j = 1; i < array.length - i; j++){
                //swap addjacent out-of-order elements
                if(array[j-1] > array[j]){
                    
                }
            }
        }
    }

    public static void bubbleSort2(int array[]){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
            
    }
}
