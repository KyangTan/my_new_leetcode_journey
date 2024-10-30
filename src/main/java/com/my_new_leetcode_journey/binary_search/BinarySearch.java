package com.my_new_leetcode_journey.binary_search;

/**
 * <h1>Binary Search</h1>
 * <h2>Easy</h2>
 * <p>
 * You are given an array of distinct integers <code>nums</code>, sorted in ascending order, and an integer <code>target</code>.
 * Implement a function to search for <code>target</code> within <code>nums</code>. 
 * If it exists, return its index; otherwise, return <code>-1</code>.
 * </p>
 * <p>
 * Your solution must run in <code>O(log n)</code> time.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: nums = [-1,0,2,4,6,8], target = 4
 * Output: 3
 * Explanation: 4 is located at index 3 in the array.
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: nums = [-1,0,2,4,6,8], target = 3
 * Output: -1
 * Explanation: 3 is not present in the array, so we return -1.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= nums.length <= 10,000</code></li>
 *   <li><code>-10,000 < nums[i], target < 10,000</code></li>
 * </ul>
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
