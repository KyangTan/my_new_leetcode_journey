package com.my_new_leetcode_journey.two_pointers;

/**
 * <h1>Trapping Rain Water</h1>
 * <h2>Hard</h2>
 * <p>
 * You are given an array of non-negative integers <code>heights</code> which
 * represent an elevation map.
 * Each value <code>heights[i]</code> represents the height of a bar, which has
 * a width of 1.
 * </p>
 * <p>
 * Return the maximum area of water that can be trapped between the bars.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: height = [0, 2, 0, 3, 1, 0, 1, 3, 2, 1]
 * Output: 9
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>1 <= height.length <= 1000</li>
 * <li>0 <= height[i] <= 1000</li>
 * </ul>
 */
public class TrappingRainWater {
    
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
    public static int trap(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int answer = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                answer += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                answer += rightMax - height[right];
            }
        }
        return answer;
    }
}
