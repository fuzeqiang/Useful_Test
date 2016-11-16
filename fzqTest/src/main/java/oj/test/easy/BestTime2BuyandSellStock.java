package oj.test.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.<br/>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p/>
 * Example 1:
 * <br/>
 * Input: [7, 1, 5, 3, 6, 4]
 * <br/>
 * Output: 5
 * <br/>
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * <br/>
 * Example 2:
 * <br/>
 * Input: [7, 6, 4, 3, 1]
 * <br/>
 * Output: 0
 * <br/>
 * In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTime2BuyandSellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int length = prices.length;
        if (0 == length) {
            return profit;
        }

        int buyPrice = prices[0];
        for (int sellPrice : prices) {
            if (buyPrice < sellPrice) {
                int tempProfit = sellPrice - buyPrice;
                profit = profit < tempProfit ? tempProfit : profit;
            } else {
                buyPrice = sellPrice;
            }
        }

        return profit;
    }

}
