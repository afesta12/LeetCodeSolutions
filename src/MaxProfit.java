public class MaxProfit {

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a
     * different day in the future to sell that stock.
     *
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * @param prices the prices of stock
     * @return max profit or 0
     */
    public static int maxProfit(int[] prices) {

        /*
        Keep track of the smallest value seen so far
         */
        int smallestValue = Integer.MAX_VALUE;

        int currentMaxProfit, maxProfit = 0;

        for (int price : prices) {

            if (price < smallestValue) smallestValue = price;

            // Get the current price - the smallest value, maxProfit will be the max throughout the loop
            currentMaxProfit = price - smallestValue;

            maxProfit = Math.max(currentMaxProfit, maxProfit);

        }

        return maxProfit;
    }
}
