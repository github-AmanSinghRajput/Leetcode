package Arrays.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfArrays {
    public static int[] intersectionBrute(int[] nums1, int[] nums2) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int current : nums1) {
            // Check if current is already in result
            boolean alreadyInResult = false;
            for (int val : result) {
                if (val == current) {
                    alreadyInResult = true;
                    break;
                }
            }
            if (alreadyInResult) continue;

            // Check if current exists in nums2
            for (int k : nums2) {
                if (k == current) {
                    result.add(current);
                    break;
                }
            }
        }

        // Convert ArrayList to int[]
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;

    }

    public static int[] interSectionArrOptimized(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<>();
        int[] smaller = nums1.length < nums2.length ? nums1 : nums2;
        int[] larger  = nums1.length < nums2.length ? nums2 : nums1;



        for(int num: smaller){
            set1.add(num);
        }
        int[] result = new int[smaller.length]; // Worst-case size
        int i = 0;

        for(int num: larger){
            if(set1.contains(num)){
                result[i++]=num;
                set1.remove(num);
            }
        }

        return Arrays.copyOfRange(result,0,i);

    }
    public static void main(String[] args) {
    int[] nums1 = {4, 9, 5};
    int[]  nums2 = {9, 4, 9, 8, 4};

    System.out.println("result is: "+ Arrays.toString(intersectionBrute(nums1,nums2)));
    System.out.println("result is: "+ Arrays.toString(interSectionArrOptimized(nums1,nums2)));
    }
}
