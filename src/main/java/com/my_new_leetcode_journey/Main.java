package com.my_new_leetcode_journey;

import com.my_new_leetcode_journey.arrays_hashing.LongestConsecutiveSequence;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,20,4,10,3,4,5};

        int answer = LongestConsecutiveSequence.longestConsecutiveHashSet(nums);

        System.out.println(answer);
    }
}