package LeetCode.medium;

// 122. Best Time to Buy and Sell Stock II

public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {

        int stockHeld = prices[0];
        int profit = 0;

        for(int i=1; i<prices.length; i++) {


            if(prices[i] > stockHeld) {
                profit = profit + prices[i] - stockHeld;
                stockHeld = prices[i];
            } else {
                stockHeld = prices[i];
            }
        }

        return profit;
    }

}
