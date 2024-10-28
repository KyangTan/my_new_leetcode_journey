package com.my_new_leetcode_journey.stack;

import java.util.Arrays;

/**
 * <h1>Car Fleet</h1>
 * <h2>Medium</h2>
 * <p>
 * There are <code>n</code> cars traveling to the same destination on a one-lane highway.
 * </p>
 * <p>
 * You are given two arrays of integers <code>position</code> and <code>speed</code>, both of length <code>n</code>.
 * </p>
 * <ul>
 *   <li><code>position[i]</code> is the position of the <code>i<sup>th</sup></code> car (in miles)</li>
 *   <li><code>speed[i]</code> is the speed of the <code>i<sup>th</sup></code> car (in miles per hour)</li>
 * </ul>
 * <p>
 * The destination is at position <code>target</code> miles.
 * </p>
 * <p>
 * A car cannot pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.
 * A <strong>car fleet</strong> is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.
 * </p>
 * <p>
 * If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: target = 10, position = [1,4], speed = [3,2]
 * Output: 1
 * Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]
 * Output: 3
 * Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li><code>n == position.length == speed.length</code></li>
 *   <li><code>1 <= n <= 1000</code></li>
 *   <li><code>0 < target <= 1000</code></li>
 *   <li><code>0 < speed[i] <= 100</code></li>
 *   <li><code>0 <= position[i] < target</code></li>
 *   <li>All values of <code>position</code> are unique.</li>
 * </ul>
 */
public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] pairs = new double[n][2];

        for(int i = 0; i< n; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a,b)-> Double.compare(b[0], a[0]));

        int fleetCount = 0;
        double[] timeToReach = new double[n];

        for(int i =0; i< n; i++){
            timeToReach[i] = (target - pairs[i][0])/pairs[i][1];
            if(i>= 1 && timeToReach[i] <= timeToReach[i-1]){
                timeToReach[i] = timeToReach[i-1];
            }else{
                fleetCount++;
            }
        }
        return fleetCount;
    }
}
