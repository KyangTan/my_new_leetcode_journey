package com.my_new_leetcode_journey.arrays_hashing;

import java.util.HashMap;

/**
 * <h1>Two Integer Sum</h1>
 * <h2>Easy</h2>
 * <p>
 * Given an array of integers <code>nums</code> and an integer <code>target</code>, 
 * return the indices <code>i</code> and <code>j</code> such that 
 * <code>nums[i] + nums[j] == target</code> and <code>i != j</code>.
 * </p>
 * <p>
 * You may assume that every input has exactly one pair of indices <code>i</code> and <code>j</code> 
 * that satisfy the condition.
 * </p>
 * <p>
 * Return the answer with the smaller index first.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: 
 * nums = [3, 4, 5, 6], target = 7
 * Output: [0, 1]
 * Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: nums = [4, 5, 6], target = 10
 * Output: [0, 2]
 * </pre>
 * 
 * <h3>Example 3:</h3>
 * <pre>
 * Input: nums = [5, 5], target = 10
 * Output: [0, 1]
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>2 <= nums.length <= 1000</li>
 *   <li>-10,000,000 <= nums[i] <= 10,000,000</li>
 *   <li>-10,000,000 <= target <= 10,000,000</li>
 * </ul>
 */
public class TwoIntegerSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevDifferenceToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            if(prevDifferenceToIndex.containsKey(num)){
                return new int[] {prevDifferenceToIndex.get(num), i};
            }
            
            int difference = target - num;
            prevDifferenceToIndex.put(difference, i);
        }

        return new int[] {};
    }
}
