package com.my_new_leetcode_journey.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <h1>Three Integer Sum</h1>
 * <h2>Medium</h2>
 * <p>
 * Given an integer array <code>nums</code>, return all the triplets
 * <code>[nums[i], nums[j], nums[k]]</code> where
 * <code>nums[i] + nums[j] + nums[k] == 0</code>, and the indices
 * <code>i</code>, <code>j</code>, and <code>k</code>
 * are all distinct.
 * </p>
 * <p>
 * The output should not contain any duplicate triplets. You may return the
 * output and the triplets in any order.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1,-1,2], [-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: nums = [0, 1, 1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * </pre>
 * 
 * <h3>Example 3:</h3>
 * 
 * <pre>
 * Input: nums = [0, 0, 0]
 * Output: [[0, 0, 0]]
 * Explanation: The only possible triplet sums up to 0.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>3 <= nums.length <= 1000</li>
 * <li>-10^5 <= nums[i] <= 10^5</li>
 * </ul>
 */
public class ThreeIntegerSum {

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p>
     * <b>Time Complexity:</b> O(n<sup>2</sup>)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(1) or O(n) depending on the sorting algorithm.
     * </p>
     * <ul>
     * <li>O(1) for in-place sorting algorithms.</li>
     * <li>O(n) for sorting algorithms that require additional space.</li>
     * </ul>
     */
    public List<List<Integer>> threeSumTwoPointersOptimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // if the smallest element is larger than 0, means there will be no sum of 3
            // elements is possible to achieve only 0
            if (nums[i] > 0)
                break;

            // if it is second element or later, then checks if it is the same with the
            // previous element, if yes, then skip
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return answer;
    }

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p>
     * <b>Time Complexity:</b> O(n<sup>2</sup>)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(1) or O(n) depending on the sorting algorithm.
     * </p>
     * <ul>
     * <li>O(1) for in-place sorting algorithms.</li>
     * <li>O(n) for sorting algorithms that require additional space.</li>
     * </ul>
     */
    public static List<List<Integer>> threeSumSelfAttempt(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> alreadyAnswered = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];

            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right--;
                }
                if (left == right) {
                    break;
                }

                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> subAnswer = new ArrayList<>();
                    subAnswer.add(nums[i]);
                    subAnswer.add(nums[left]);
                    subAnswer.add(nums[right]);

                    subAnswer.sort((a, b) -> a - b);

                    StringBuilder sb = new StringBuilder();

                    for (Integer integer : subAnswer) {
                        sb.append(integer);
                    }

                    String checkContainString = sb.toString();

                    if (!alreadyAnswered.contains(checkContainString)) {
                        alreadyAnswered.add(checkContainString);
                        answer.add(subAnswer);
                    }
                    right--;
                } else {
                    if (nums[left] + nums[right] < target) {
                        left++;
                    }
                    if (nums[left] + nums[right] > target) {
                        right--;
                    }
                }
            }
        }

        return answer;
    }
}
