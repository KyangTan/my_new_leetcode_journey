package com.my_new_leetcode_journey;

import java.util.List;

import com.my_new_leetcode_journey.binary_search.FindMinimumInRotatedSortedArray;
import com.my_new_leetcode_journey.stack.DailyTemperatures;
import com.my_new_leetcode_journey.stack.EvaluateReversePolishNotation;
import com.my_new_leetcode_journey.stack.GenerateParentheses;
import com.my_new_leetcode_journey.stack.LargestRectangleInHistogram;
import com.my_new_leetcode_journey.stack.ValidateParentheses;
import com.my_new_leetcode_journey.two_pointers.MaxWaterContainer;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,1};

        int answer = FindMinimumInRotatedSortedArray.findMin(nums);
        System.out.println(answer);
    }
}