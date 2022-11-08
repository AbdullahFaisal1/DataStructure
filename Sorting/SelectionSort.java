package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] input = {4, 2, 9, 6, 23, 12, 34, 0, 1};
        selectionSort(input);
        
        for(int i=0; i< input.length; i++)
            System.out.print(input[i] + ", ");
        System.out.println("\n");  
    }

	private static void selectionSort(int[] array) {
		
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		
	}
}
