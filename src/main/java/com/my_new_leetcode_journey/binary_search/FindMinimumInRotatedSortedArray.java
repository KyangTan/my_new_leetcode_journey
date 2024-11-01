package com.my_new_leetcode_journey.binary_search;

/**
 * <h1>Find Minimum in Rotated Sorted Array</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given an integer array <code>nums</code> of unique elements that was originally sorted in ascending order 
 * but has been rotated between <code>1</code> and <code>n</code> times. For example, an array <code>nums = [1,2,3,4,5,6]</code> 
 * might become <code>[3,4,5,6,1,2]</code> if rotated 4 times. This method returns the smallest element in the array.
 * </p>
 * <p>
 * This implementation achieves an efficient runtime of <code>O(log n)</code> using binary search, where <code>n</code> is the array's length.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: nums = [3,4,5,6,1,2]
 * Output: 1
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: nums = [4,5,0,1,2,3]
 * Output: 0
 * </pre>
 * 
 * <h3>Example 3:</h3>
 * <pre>
 * Input: nums = [4,5,6,7]
 * Output: 4
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= nums.length <= 1000</code></li>
 *   <li><code>-1000 <= nums[i] <= 1000</code></li>
 *   <li>All elements of <code>nums</code> are unique.</li>
 * </ul>
 *
 * @param nums an array of integers representing a rotated sorted array of unique elements
 * @return the minimum element in the rotated sorted array
 */
public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int min = nums[l];

        while (l <= r) {
            int m = (r + l) / 2;

            if (nums[m] < min) {
                min = nums[m];
            }

            if(l == r){
                break;
            }

            if (nums[l] > nums[r]) {
                if (nums[m] < nums[r]) {
                    r = m - 1;
                } else if (nums[m] > nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (nums[r] > nums[l]) {
                if (nums[m] < nums[l]) {
                    l = m + 1;
                } else if (nums[m] > nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }
        return min;
    }
}
