package SlidingWindow.Easy;

public class BestTimeToBuyAndSellStock {
    private int bruteForceMaxProfit(int[] prices){
        int maxProfit = 0;
        for(int i=0; i < prices.length-1; i++){
            for(int j = i+1; j<prices.length; j++){
                maxProfit = Math.max(maxProfit, prices[j]-prices[i]);
            }
        }
        return maxProfit;
    };

    private int optimizedSlidingWindowMaxProfit(int[] prices){
        int maxProfit = 0;
        int currentMin = prices[0];
        for(int i=0;i<prices.length;i++){
            if(prices[i]>currentMin){
                maxProfit = Math.max(maxProfit, prices[i]-currentMin);
            }else{
                currentMin = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();

        int[][] tests = {
                {7,1,5,3,6,4},          // classic profitable case → 5  (buy 1, sell 6)
                {7,6,4,3,1},            // strictly decreasing → 0
                {1,2,3,4,5},            // strictly increasing → 4  (buy 1, sell 5)
                {2,2,2,2},              // flat prices → 0
                {3},                    // single element → 0
                {2,4,1},                // profit by buying 2, sell 4 → 2
                {3,3,5,0,0,3,1,4},      // duplicates + ups/downs → 4  (buy 0, sell 4)
                // long random-ish array (stress test)
                {9, 11, 8, 5, 7, 10, 1, 6, 8, 4, 10, 15, 2, 3, 2}
        };

        for (int[] prices : tests) {
            int brute = obj.bruteForceMaxProfit(prices);
            int opt   = obj.optimizedSlidingWindowMaxProfit(prices);

            System.out.println("Prices  : " + java.util.Arrays.toString(prices));
            System.out.println("Brute   : " + brute);
            System.out.println("Optim   : " + opt);
            System.out.println(brute == opt ? "✅ Passed" : "❌ Mismatch");
            System.out.println("------------------------------");
        }
    }
}
