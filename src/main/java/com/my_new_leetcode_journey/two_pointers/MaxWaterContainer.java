package com.my_new_leetcode_journey.two_pointers;

/**
 * <h1>Max Water Container</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given an integer array <code>heights</code> where
 * <code>heights[i]</code> represents the height of the
 * <code>i</code><sup>th</sup> bar.
 * </p>
 * <p>
 * You may choose any two bars to form a container. Return the maximum amount of
 * water a container can store.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: height = [1, 7, 2, 5, 4, 7, 3, 6]
 * Output: 36
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: height = [2, 2, 2]
 * Output: 4
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>2 <= height.length <= 1000</li>
 * <li>0 <= height[i] <= 1000</li>
 * </ul>
 */
public class MaxWaterContainer {

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p>
     * <b>Time Complexity:</b> O(n)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(1)
     * </p>
     * <ul>
     * <li>Constant space usage, independent of input size.</li>
     * </ul>
     */
    public int maxAreaOptimal(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int res = 0;
        
        while (l < r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            res = Math.max(res, area);
            if (heights[l] <= heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p>
     * <b>Time Complexity:</b> O(n)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(1)
     * </p>
     * <ul>
     * <li>Constant space usage, independent of input size.</li>
     * </ul>
     */
    public static int maxAreaSelfAttempt(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int max = 0;
        while (left < right) {
            if (heights[left] > heights[right]) {
                int temp = heights[right] * (right - left);
                if (temp > max) {
                    max = temp;
                }
                right--;
            }
            if (heights[right] > heights[left]) {
                int temp = heights[left] * (right - left);
                if (temp > max) {
                    max = temp;
                }
                left++;
            }
            if (heights[right] == heights[left]) {
                int temp = heights[left] * (right - left);
                if (temp > max) {
                    max = temp;
                }
                left++;
            }
        }
        return max;
    }
}
