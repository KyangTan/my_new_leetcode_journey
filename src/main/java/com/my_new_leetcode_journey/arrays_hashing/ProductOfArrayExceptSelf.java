package com.my_new_leetcode_journey.arrays_hashing;

/**
 * <h1>Products of Array Discluding Self</h1>
 * <h2>Medium</h2>
 * <p>
 * Given an integer array <code>nums</code>, return an array <code>output</code>
 * where <code>output[i]</code> is the product of all the elements of
 * <code>nums</code>
 * except <code>nums[i]</code>.
 * </p>
 * <p>
 * Each product is guaranteed to fit in a 32-bit integer.
 * </p>
 * <p>
 * <strong>Follow-up:</strong> Could you solve it in <code>O(n)</code> time
 * without using
 * the division operation?
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: nums = [1, 2, 4, 6]
 * Output: [48, 24, 12, 8]
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: nums = [-1, 0, 1, 2, 3]
 * Output: [0, -6, 0, 0, 0]
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>2 <= nums.length <= 1000</li>
 * <li>-20 <= nums[i] <= 20</li>
 * </ul>
 */

public class ProductOfArrayExceptSelf {

    /**
     * <p>
     * <b>Time Complexity:</b> O(n)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the array.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(1)
     * </p>
     * <ul>
     * <li>Constant space usage, regardless of input size.</li>
     * </ul>
     */
    public static int[] productExceptSelfPrefixSuffixOptimal(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }

        return res;

    }

    /**
     * <p>
     * <b>Time Complexity:</b> O(n)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the array.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(n)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the array.</li>
     * </ul>
     */
    public static int[] productExceptSelfPrefixSuffix(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
            System.out.println("pref : " + nums[i - 1] + " " + pref[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
            System.out.println("suff : " + nums[i + 1] + " " + suff[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
            System.out.println("res : " + pref[i] + " " + suff[i]);
        }
        return res;
    }


    /**
     * <p>
     * <b>Time Complexity:</b> O(n)
     * </p>
     * <ul>
     * <li>Where <code>n</code> is the length of the array.</li>
     * </ul>
     * 
     * <p>
     * <b>Space Complexity:</b> O(1)
     * </p>
     * <ul>
     * <li>Constant space usage, regardless of input size.</li>
     * </ul>
     */
    public static int[] productExceptSelfDivision(int[] nums){
        int[] res = new int[nums.length];

        int prod = 1;
        int zeroCount =0;
        for (int i = 0; i < res.length; i++) {
            if(nums[i] != 0){
                prod *= nums[i];
            }else{
                zeroCount++;
            }
        }

        if(zeroCount>1){
            return new int[nums.length];
        }

        for (int i = 0; i < res.length; i++) {
            if (zeroCount > 0) {
                if (nums[i] == 0) {
                    res[i] = prod;
                }else{
                    res[i] = 0;
                }
                continue;
            }

            res[i] = prod/nums[i];
        }

        return res;
    }
}
