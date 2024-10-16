package com.my_new_leetcode_journey.arrays_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <h1>Top K Elements in List</h1>
 * <h2>Medium</h2>
 * <p>
 * Given an integer array <code>nums</code> and an integer <code>k</code>,
 * return the
 * <code>k</code> most frequent elements within the array.
 * </p>
 * <p>
 * The test cases are generated such that the answer is always unique.
 * </p>
 * <p>
 * You may return the output in any order.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: nums = [1, 2, 2, 3, 3, 3], k = 2
 * Output: [2, 3]
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: nums = [7, 7], k = 1
 * Output: [7]
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>1 <= nums.length <= 10^4</li>
 * <li>-1000 <= nums[i] <= 1000</li>
 * <li>1 <= k <= number of distinct elements in <code>nums</code></li>
 * </ul>
 */
public class TopKElementInList {

    /**
     * Calculates the time and space complexity of the algorithm.
     *
     * <p>
     * <b>Time Complexity:</b> O(n)
     * </p>
     *
     * <p>
     * <b>Space Complexity:</b> O(n)
     * </p>
     * 
     * <ul>
     * <li>Where <code>n</code> is the input size.</li>
     * </ul>
     */
    public static int[] topKFrequentBucketSort(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p>
     * <b>Time Complexity:</b> O(n log k)
     * </p>
     * 
     * <p>
     * <b>Space Complexity:</b> O(n + k)
     * </p>
     * 
     * <ul>
     * <li>Where <code>n</code> is the length of the array.</li>
     * <li><code>k</code> is the number of top frequent elements.</li>
     * </ul>
     */
    public static int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.add(new int[] { entry.getValue(), entry.getKey() });
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = heap.poll()[1];
        }

        return answer;
    }
}
