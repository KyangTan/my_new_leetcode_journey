package com.my_new_leetcode_journey;

import java.util.List;

import com.my_new_leetcode_journey.binary_search.FindMinimumInRotatedSortedArray;
import com.my_new_leetcode_journey.binary_search.FubdTargetInRotatedSortedArray;
import com.my_new_leetcode_journey.stack.DailyTemperatures;
import com.my_new_leetcode_journey.stack.EvaluateReversePolishNotation;
import com.my_new_leetcode_journey.stack.GenerateParentheses;
import com.my_new_leetcode_journey.stack.LargestRectangleInHistogram;
import com.my_new_leetcode_journey.stack.ValidateParentheses;
import com.my_new_leetcode_journey.two_pointers.MaxWaterContainer;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3,5,1};
        int target = 3;

        int number = FubdTargetInRotatedSortedArray.search(nums, target);

        System.out.println(number);

    }
}