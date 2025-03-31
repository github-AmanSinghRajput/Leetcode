package BasicJava;

import java.util.Arrays;

public class ArrayExercises {

    // 🔁 1. Reverse an array
    public static void reverseArray(int[] arr){
        int left = 0, right = arr.length -1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left +=1;
            right -=1;
        }
    }

    // 🔍 2. Find the maximum element
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int num: arr){
            if(num > max) max = num;
        }
        return max;
    }

    // 📉 3. Check if the array is sorted
    public static boolean isSorted(int[] arr){
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 9, 1};
        // 🔁 Reverse
        reverseArray(nums);
        System.out.println("Reversed: " + Arrays.toString(nums));

        System.out.println("Max element: " + findMax(nums));

        // ✅ Check if sorted
        boolean sorted = isSorted(nums);
        System.out.println("Is Sorted? " + sorted);

    }


}
