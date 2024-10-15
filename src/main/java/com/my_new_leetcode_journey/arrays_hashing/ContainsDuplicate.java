package com.my_new_leetcode_journey.arrays_hashing;

import java.util.HashSet;

/**
 * <h1>Duplicate Integer</h1>
 * <h2>Easy</h2>
 * <p>
 * Given an integer array <code>nums</code>, return <code>true</code> if any value 
 * appears more than once in the array; otherwise, return <code>false</code>.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: nums = [1, 2, 3, 3]
 * Output: true
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: nums = [1, 2, 3, 4]
 * Output: false
 * </pre>
 * 
 */
public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for(int num : nums){
            if(hashSet.contains(num)){
                return true;
            }
            hashSet.add(num);
        }
        return false;
    }
}
