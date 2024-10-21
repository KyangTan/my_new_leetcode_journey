package com.my_new_leetcode_journey;

import com.my_new_leetcode_journey.arrays_hashing.LongestConsecutiveSequence;
import com.my_new_leetcode_journey.two_pointers.TwoIntegerSumII;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-5,-3,0,2,4,6,8};
        int target = 5;

        int[] answer = TwoIntegerSumII.twoSumTwoPointersMyAttempt(nums, target);

        System.out.print("answer: [");
        for (int i : answer) {
            System.out.print(i);
        }
        System.out.print("answer: ]");
    }
}