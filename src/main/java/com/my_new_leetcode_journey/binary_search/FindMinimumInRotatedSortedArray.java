package com.my_new_leetcode_journey.binary_search;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int min = nums[l];

        while (l <= r) {
            int m = (r + l) / 2;

            if (nums[m] < min) {
                min = nums[m];
            }

            if(l == r){
                break;
            }

            if (nums[l] > nums[r]) {
                if (nums[m] < nums[r]) {
                    r = m - 1;
                } else if (nums[m] > nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else if (nums[r] > nums[l]) {
                if (nums[m] < nums[l]) {
                    l = m + 1;
                } else if (nums[m] > nums[l]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }
        return min;
    }
}
