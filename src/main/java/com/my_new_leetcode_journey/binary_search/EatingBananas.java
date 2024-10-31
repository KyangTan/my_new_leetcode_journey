package com.my_new_leetcode_journey.binary_search;

import java.util.Arrays;

/**
 * <h1>Eating Bananas</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given an integer array <code>piles</code> where <code>piles[i]</code> is the number of bananas in the ith pile. 
 * You are also given an integer <code>h</code>, which represents the number of hours you have to eat all the bananas.
 * </p>
 * <p>
 * You may decide your bananas-per-hour eating rate <code>k</code>. Each hour, you can choose a pile of bananas and eat <code>k</code> bananas from that pile. 
 * If a pile has fewer than <code>k</code> bananas, you may finish eating that pile, but you cannot eat from another pile in the same hour.
 * </p>
 * <p>
 * Return the minimum integer <code>k</code> such that you can eat all the bananas within <code>h</code> hours.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: piles = [1,4,3,2], h = 9
 * Output: 2
 * Explanation: With an eating rate of 2, you can eat all the bananas in 6 hours.
 * With an eating rate of 1, you would need 10 hours (exceeds h=9), so the minimum rate is 2.
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: piles = [25,10,23,4], h = 4
 * Output: 25
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>1 <= piles.length <= 1000</code></li>
 *   <li><code>piles.length <= h <= 1,000,000</code></li>
 *   <li><code>1 <= piles[i] <= 1,000,000,000</code></li>
 * </ul>
 */
public class EatingBananas {
        public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();

        int minK = r;

        while(l <= r){
            int m = (r+l)/2;
            int totalTimeTaken = 0;

            for(int pile : piles){
                totalTimeTaken += (Math.ceil((double) pile/m));
            }

            if(totalTimeTaken <= h){
                    minK = m;
                    r = m -1;
                }else{
                    l = m+1;
                }
        }
        return minK;
    }
}
