package Arrays.Easy;

import java.util.HashMap;

public class TwoSum {


    //Brute Force Solution

    public static int[] twoSumBrute(int[] nums, int target){
        int[] sumIndices = new int[2];
        for(int i=0;i<nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target) {
                    sumIndices[0] = i;
                    sumIndices[1] = j;
                    return sumIndices;
                }
            }
        }
        return new int[] {-1, -1};
    }

    // Optimized Using HashMap

    public static int[] twoSumOptimized(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1, -1};
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSumBrute(nums, target);
        System.out.println("Brute: [" + result[0] + ", " + result[1] + "]");

        int[] result2 = twoSumOptimized(nums, target);
        System.out.println("Optimized: [" + result2[0] + ", " + result2[1] + "]");
    }
}
