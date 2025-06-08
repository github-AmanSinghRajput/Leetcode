package TwoPointers.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    protected List<List<Integer>> threeSumOptimized(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // nlog(n)

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            twoSum(nums, i, result);

        }

        return result;

    }
    private void twoSum(int[] nums, int i, List<List<Integer>> result){
        int j = i+1;
        int k = nums.length -1;
        while(j<k){
            int sum = nums[i] + nums[j] + nums[k];
            if(sum == 0){
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j = skipDuplicatesForward(nums,j,k);
                k = skipDuplicatesBackward(nums,j,k);
                j++;
                k--;
            }else if(sum < 0){
                j+=1;
            }else{
                k-=1;
            }
        }
    }

    private int skipDuplicatesForward(int[] nums, int j, int k){
        while(j < k && nums[j] == nums[j+1]){
            j++;
        }
        return j;
    }

    private int skipDuplicatesBackward(int[] nums, int j, int k){
        while(j < k && nums[k] == nums[k-1]){
            k--;
        }
        return k;
    }


    public static void main(String[] args) {
        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4},         // Typical case
                {0, 0, 0, 0},                  // All zeros (should return [0,0,0])
                {},                            // Empty array
                {0},                           // Single element
                {-2, 0, 1, 1, 2},              // Multiple triplets, with duplicates
                {-4, -2, -2, 0, 1, 2, 2, 4},   // Positive and negative mix
                {3, 0, -2, -1, 1, 2},          // Unordered positive + negative
                {1, 2, -2, -1}                 // No triplet sums to zero
        };

        ThreeSum obj = new ThreeSum(); // Replace with your class name
        for (int[] testCase : testCases) {
            List<List<Integer>> result = obj.threeSumOptimized(testCase);
            System.out.println("Input: " + Arrays.toString(testCase));
            System.out.println("3Sum Result: " + result);
            System.out.println("--------------");
        }
    }
}
