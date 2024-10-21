package com.my_new_leetcode_journey.two_pointers;

/**
 * <h1>Two Integer Sum II</h1>
 * <h2>Medium</h2>
 * <p>
 * Given an array of integers <code>numbers</code> that is sorted in
 * non-decreasing order, return the indices (1-indexed)
 * of two numbers, <code>[index1, index2]</code>, such that they add up to a
 * given target number <code>target</code>
 * and <code>index1 &lt; index2</code>. Note that <code>index1</code> and
 * <code>index2</code> cannot be equal,
 * so you may not use the same element twice.
 * </p>
 * <p>
 * There will always be exactly one valid solution.
 * </p>
 * <p>
 * Your solution must use <code>O(1)</code> additional space.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: numbers = [1, 2, 3, 4], target = 3
 * Output: [1, 2]
 * Explanation: The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>2 <= numbers.length <= 1000</li>
 * <li>-1000 <= numbers[i] <= 1000</li>
 * <li>-1000 <= target <= 1000</li>
 * </ul>
 */
public class TwoIntegerSumII {

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <ul>
     *     <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1)</p>
     * <ul>
     *     <li>Constant space usage, regardless of input size.</li>
     * </ul>
     */
    public static int[] twoSumTwoPointersMyAttempt(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[right] > target && (numbers[left] < target && numbers[left]>0)) {
            right--;
            if (numbers[right] == target && numbers[left] == 0) {
                right--;
            }
        }

        System.out.println("left : " + left);
        System.out.println("right : " + right);
        
        int[] answer = {};
        do{
            if(numbers[right]+numbers[left] == target){
                answer = new int[] {left+1, right+1};
                break;
            }else if(numbers[right] + numbers[left] > target){
                System.out.println("right-- " + right + " -> " + (right-1));
                right--;
            }else if(numbers[right] + numbers[left] < target){
                System.out.println("left++" + left + " -> " + (left+1));
                left ++;
            }
        }while(right > left && left != right);

        return answer;
    }
}
