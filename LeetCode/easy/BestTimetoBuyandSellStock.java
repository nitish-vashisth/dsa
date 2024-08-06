package LeetCode.easy;

/*

121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

Date : 6 Aug 2024
*/
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {

        int min = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++) {
            if(min < prices[i])
                maxProfit = Math.max(maxProfit, (prices[i]-min));
            else
                min = prices[i];
        }

        return maxProfit;
    }
}
