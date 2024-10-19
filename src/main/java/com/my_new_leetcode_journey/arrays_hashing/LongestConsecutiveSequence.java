package com.my_new_leetcode_journey.arrays_hashing;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <h1>Longest Consecutive Sequence</h1>
 * <h2>Medium</h2>
 * <p>
 * Given an array of integers <code>nums</code>, return the length of the longest consecutive sequence of elements.
 * </p>
 * <p>
 * A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element.
 * </p>
 * <p>
 * You must write an algorithm that runs in <code>O(n)</code> time.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: nums = [2, 20, 4, 10, 3, 4, 5]
 * Output: 4
 * Explanation: The longest consecutive sequence is [2, 3, 4, 5].
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: nums = [0, 3, 2, 5, 4, 6, 1, 1]
 * Output: 7
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>0 <= nums.length <= 1000</li>
 *   <li>-10^9 <= nums[i] <= 10^9</li>
 * </ul>
 */
public class LongestConsecutiveSequence {

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p><b>Time Complexity:</b> O(n log n)</p>
     * <ul>
     *     <li>Where <code>n</code> is the length of the array.</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1)</p>
     * <ul>
     *     <li>Constant space usage, independent of input size.</li>
     * </ul>
     */
    public static int LongestConsecutiveSorting(int[] nums){
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }


    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * <ul>
     *     <li>Where <code>n</code> is the length of the array.</li>
     * </ul>
     */
    public static int longestConsecutiveHashSet(int[] nums) {
       HashSet<Integer> hs = new HashSet<>();

       for (Integer num: nums) {
            hs.add(num);
       }

       int longest = 0;

       for (Integer num : nums) {
            if(!hs.contains(num-1)){
                int next = num-1;
                int counter = 0;
                while (hs.contains(next +1)) {
                    counter++;
                    next++;
                }
                if(counter > longest){
                    longest = counter;
                }
            }
       }

       return longest;
    }
}
