package Arrays.Medium;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int minProduct = nums[0];
        int maxProduct = nums[0];
        for(int i=1;i<nums.length; i++){
            int current = nums[i];
            // store previous values before updating
            int tempMax = maxProduct;

            maxProduct = Math.max(current, Math.max(current * maxProduct, current*minProduct));
            minProduct = Math.min(current, Math.min(current * tempMax, current * minProduct));
            result = Math.max(result,maxProduct);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
