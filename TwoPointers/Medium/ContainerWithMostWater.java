package TwoPointers.Medium;

public class ContainerWithMostWater {
    private int bruteMaxArea(int[] height){
        int maxArea = 0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int width = j - i;
                int h = Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea,width * h);

            }
        }
        return maxArea;
    }
    private int optimizedMaxArea(int[] height){
        int maxArea = 0;
        int i = 0;
        int j = height.length -1;
        while(i<j){
            int width = j-i;
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, width * h);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();

        int[][] testCases = {
                {1, 8, 6, 2, 5, 4, 8, 3, 7},       // Normal case (LeetCode Example)
                {1, 1},                             // Minimal input, two lines
                {4, 3, 2, 1, 4},                    // Multiple possible max areas
                {1, 2, 1},                          // Small array
                {1, 3, 2, 5, 25, 24, 5},            // Peak somewhere in middle
                {2, 3, 4, 5, 18, 17, 6},            // Increasing then decreasing
                {1, 2, 4, 3},                       // Small peak in middle
                {1, 1000, 1000, 6, 2, 5, 4, 8, 3, 7}, // Large middle walls
                {100, 200, 300, 400, 500, 400, 300, 200, 100}, // Symmetric
                {1, 2},                             // Just 2 lines
                {5},                                // Single element (edge case)
                {}                                  // Empty array (edge case)
        };

        for (int[] height : testCases) {
            int bruteResult = obj.bruteMaxArea(height);
            int optimizedResult = obj.optimizedMaxArea(height);

            System.out.println("Input: " + java.util.Arrays.toString(height));
            System.out.println("Brute Force Result: " + bruteResult);
            System.out.println("Optimized Result: " + optimizedResult);
            System.out.println((bruteResult == optimizedResult ? "✅ PASSED" : "❌ FAILED"));
            System.out.println("---------------------------------");
        }
    }

}
