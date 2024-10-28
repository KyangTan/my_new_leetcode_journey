package com.my_new_leetcode_journey.stack;

import java.util.Stack;

/**
 * <h1>Daily Temperatures</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given an array of integers <code>temperatures</code> where <code>temperatures[i]</code> represents the daily temperature on the <code>i<sup>th</sup></code> day.
 * </p>
 * <p>
 * Return an array <code>result</code> where <code>result[i]</code> is the number of days after the <code>i<sup>th</sup></code> day until a warmer temperature appears on a future day.
 * </p>
 * <p>
 * If there is no future day with a warmer temperature, set <code>result[i]</code> to 0.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: temperatures = [30,38,30,36,35,40,28]
 * Output: [1,4,1,2,1,0,0]
 * Explanation:
 * - On day 0, the next warmer temperature is on day 1, so result[0] = 1.
 * - On day 1, the next warmer temperature is on day 5, so result[1] = 4.
 * - And so on...
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: temperatures = [22,21,20]
 * Output: [0,0,0]
 * Explanation: There are no warmer temperatures in the future for any day.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= temperatures.length <= 1000</code></li>
 *   <li><code>1 <= temperatures[i] <= 100</code></li>
 * </ul>
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
                int indexStackNumber = indexStack.pop();
                stack.pop();
                int length = i - indexStackNumber;
                answer[indexStackNumber] = length;
            }
            stack.push(temperatures[i]);
            indexStack.push(i);
        }
        return answer;
    }
}
