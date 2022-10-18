package BinarySearching;

public class SearchTest {
    public static boolean binarySearch(int[] arr, int target, int low, int high){
        if(low > high) return false;
        else{
            int mid = (low + high) / 2;
            if(target == arr[mid]){
                return true;
            }
            else if(target < arr[mid]){
                return binarySearch(arr, target, low, mid-1);
            }
            else{
                return binarySearch(arr, target, mid+1, high);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        
        System.out.println( binarySearch(arr, 14, 0, arr.length-1) );
    }
}
