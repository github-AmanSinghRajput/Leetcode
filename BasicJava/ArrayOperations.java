package BasicJava;
import java.util.Arrays;

public class ArrayOperations {

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 9, 1, 5};

        // 🔹 Sort the array
        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        // 🔹 Find Min and Max
        int min = nums[0];
        int max = nums[nums.length -1];
        System.out.println("Min: "+ min + " Max: "+ max);

        // 🔹 Calculate Sum
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 🔹 Calculate Average
        double avg = (double) sum / nums.length ;
        System.out.println("Sum: " + sum + ", Average: " + avg);

    }
}
