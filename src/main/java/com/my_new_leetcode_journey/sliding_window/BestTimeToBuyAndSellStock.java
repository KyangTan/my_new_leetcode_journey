package com.my_new_leetcode_journey.sliding_window;

/**
 * <h1>Buy and Sell Crypto</h1>
 * <h2>Easy</h2>
 * <p>
 * You are given an integer array <code>prices</code> where
 * <code>prices[i]</code> represents the price of NeetCoin on the
 * <code>i<sup>th</sup></code> day.
 * The goal is to maximize profit by choosing a single day to buy one NeetCoin
 * and a different day in the future to sell it.
 * </p>
 * <p>
 * Return the maximum profit you can achieve. If no profitable transaction can
 * be made, return <code>0</code>.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: prices = [10,1,5,6,7,1]
 * Output: 6
 * Explanation: Buy at prices[1] (1) and sell at prices[4] (7), resulting in profit = 7 - 1 = 6.
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: prices = [10,8,7,5,2]
 * Output: 0
 * Explanation: No profitable transactions are possible, so the maximum profit is 0.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li><code>1 <= prices.length <= 100</code></li>
 * <li><code>0 <= prices[i] <= 100</code></li>
 * </ul>
 * 
 * @param prices an integer array representing the price of NeetCoin on each day
 * @return the maximum profit possible from a single buy and sell transaction,
 *         or 0 if no profitable transaction exists
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfitDP(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }

    public int maxProfitMyAttempt(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int lowest = prices[0];
        int highest = prices[1];
        int profit = highest - lowest;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
                if (i + 1 < prices.length) {
                    highest = prices[i + 1];
                    i = i + 1;
                } else {
                    highest = prices[i];
                }
                int tempProfit = highest - lowest;
                if (tempProfit > profit) {
                    profit = tempProfit;
                }
            }

            if (prices[i] > highest) {
                highest = prices[i];
                profit = highest - lowest;
            }
        }

        if (profit <= 0) {
            return 0;
        }

        return profit;
    }
}
