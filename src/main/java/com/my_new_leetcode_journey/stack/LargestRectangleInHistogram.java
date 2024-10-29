package com.my_new_leetcode_journey.stack;

import java.util.Stack;

/**
 * <h1>Largest Rectangle in Histogram</h1>
 * <h2>Hard</h2>
 * <p>
 * You are given an array of integers <code>heights</code> where <code>heights[i]</code> represents the height of a bar.
 * The width of each bar is 1.
 * </p>
 * <p>
 * Return the area of the largest rectangle that can be formed among the bars.
 * </p>
 * <p>
 * Note: This chart is known as a histogram.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: heights = [7,1,7,2,2,4]
 * Output: 8
 * Explanation:
 * - The largest rectangle is formed by the bars at indices 0 and 2, both with height 7, resulting in an area of 8.
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: heights = [1,3,7]
 * Output: 7
 * Explanation:
 * - The largest rectangle is the single bar at index 2 with height 7 and width 1.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= heights.length <= 1000</code></li>
 *   <li><code>0 <= heights[i] <= 1000</code></li>
 * </ul>
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int largest = 0;

        for(int i = 0 ; i< heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && heights[i] < stack.peek()[1]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                largest = Math.max(largest, height * (i - index));
                start = index;
            }
            stack.push(new int[] {start, heights[i]});
        }

        for(int[] pair : stack){
            int index = pair[0];
            int height = pair[1];

            largest = Math.max(largest, height* (heights.length - index));
        }

        return largest;
    }
}
