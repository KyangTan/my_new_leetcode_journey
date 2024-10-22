package com.my_new_leetcode_journey;

import java.util.List;

import com.my_new_leetcode_journey.arrays_hashing.LongestConsecutiveSequence;
import com.my_new_leetcode_journey.two_pointers.ThreeIntegerSum;
import com.my_new_leetcode_journey.two_pointers.TwoIntegerSumII;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};

        List<List<Integer>> answer = ThreeIntegerSum.threeSumSelfAttempt(nums);

        // System.out.print("answer: [");
        // for (int i : answer) {
        //     System.out.print(i);
        // }
        // System.out.print("answer: ]");
    }
}