package Arrays.Medium;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] answer = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            int product = 1;
            for(int k=0;k<nums.length;k++){
                if(i!=k){
                    product *= nums[k];
                }
            }
            answer[i] = product;
        }
    return answer;
    }

    public int[] productExceptSelfOptimized(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        // Step 1: Build prefix product array directly into answer[]
        answer[0] = 1;

        for(int i=1; i<n; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }
//        step 2: Multiply suffix product from the right
        int suffixProduct = 1;
        for(int i=n-1; i>=0; i--){
            answer[i] = answer[i-1] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
