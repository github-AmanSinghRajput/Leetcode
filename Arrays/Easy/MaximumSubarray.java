package Arrays.Easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        for(int i = 0; i<nums.length; i++){
            int sum = nums[i];
            for(int k=i+1;k<nums.length;k++){
                sum += nums[k];
                if(sum>maxSum) maxSum=sum;
            }
        }

        return maxSum;
    }
// Optimized solution
    public int maxSubArrayKadensAlgo(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int i= 1; i<nums.length;i++){
// Either start fresh from nums[i] OR extend previous subarray
            currentSum = Math.max(nums[i], currentSum+nums[i]);
            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
