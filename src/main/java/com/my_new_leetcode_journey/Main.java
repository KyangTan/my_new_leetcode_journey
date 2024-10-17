package com.my_new_leetcode_journey;

import com.my_new_leetcode_journey.arrays_hashing.ContainsDuplicate;
import com.my_new_leetcode_journey.arrays_hashing.ProductOfArrayExceptSelf;

public class Main {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,3};

        int[] answer = ProductOfArrayExceptSelf.productExceptSelfDivision(nums);

        System.out.print("Answer: [");
        for (int i : answer) {
            System.out.print(i+ ",");
        }
        System.out.println("]");
    }
}