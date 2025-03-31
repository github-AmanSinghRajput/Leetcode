package Arrays.Easy;

import java.util.HashSet;

public class ContainsDuplicate {
    // 🔁 Brute force solution
    public static boolean containsDuplicateBrute(int[] arr){
        for(int i = 0; i< arr.length; i++){
            for(int j = i + 1; j< arr.length; j++){
                if(arr[i] == arr[j]) return true;
            }
        }
        return false;
    }

    //Optimized Solution using HashSet

    public static boolean containsDuplicateOptimized(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        boolean bruteForceResult = containsDuplicateBrute(nums);
        System.out.println("Brute force Contains duplicate? " + bruteForceResult);

        boolean hashSetResult = containsDuplicateOptimized(nums);
        System.out.println("Optimized Contains duplicate? " + hashSetResult);

    }
}
