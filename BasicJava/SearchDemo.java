package BasicJava;

import java.util.Arrays;

public class SearchDemo {
    public static int linearSearch(int[] arr, int target){
        for(int i = 0; i < arr.length; i++){
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // 🔍 Binary Search: works only on sorted arrays
    public static int binarySearch(int[] arr, int target){
        int low = 0;
        int high = arr.length -1 ;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {9, 3, 5, 1, 7};
        int target = 5;

        int result1 = linearSearch(nums, target);
        System.out.println("Linear Search → Found at index: " + result1);

        // Binary Search (sorted)
        Arrays.sort(nums); // required for binary search
        int result2 = binarySearch(nums,target);
        System.out.println("Binary Search → Found at index: " + result2);
    }
}
