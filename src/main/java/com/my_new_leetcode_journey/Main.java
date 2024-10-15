package com.my_new_leetcode_journey;

import com.my_new_leetcode_journey.arrays_hashing.ContainsDuplicate;

public class Main {
    public static void main(String[] args) {
         int[] nums = {1, 2, 3, 3};
        boolean answer = ContainsDuplicate.hasDuplicate(nums);

        System.out.println(answer);
    }
}