package com.my_new_leetcode_journey.arrays_hashing;

import java.util.HashSet;

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
