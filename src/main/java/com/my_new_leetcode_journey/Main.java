package com.my_new_leetcode_journey;

import com.my_new_leetcode_journey.two_pointers.MaxWaterContainer;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,2,2};

        int answer = MaxWaterContainer.maxAreaSelfAttempt(nums);

        System.out.println(answer);

        // List<List<Integer>> answer = ThreeIntegerSum.threeSumSelfAttempt(nums);

        // System.out.print("answer: [");
        // for (int i : answer) {
        //     System.out.print(i);
        // }
        // System.out.print("answer: ]");
    }
}