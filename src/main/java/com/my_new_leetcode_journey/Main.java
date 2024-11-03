package com.my_new_leetcode_journey;

import java.util.List;

import com.my_new_leetcode_journey.binary_search.FindMinimumInRotatedSortedArray;
import com.my_new_leetcode_journey.binary_search.FindTargetInRotatedSortedArray;
import com.my_new_leetcode_journey.binary_search.TimeBasedKeyValueStore;
import com.my_new_leetcode_journey.stack.DailyTemperatures;
import com.my_new_leetcode_journey.stack.EvaluateReversePolishNotation;
import com.my_new_leetcode_journey.stack.GenerateParentheses;
import com.my_new_leetcode_journey.stack.LargestRectangleInHistogram;
import com.my_new_leetcode_journey.stack.ValidateParentheses;
import com.my_new_leetcode_journey.two_pointers.MaxWaterContainer;

public class Main {
    public static void main(String[] args) {
        TimeBasedKeyValueStore tbkvs = new TimeBasedKeyValueStore();

        // tbkvs.set("alice", "happy", 1);
        // String get1 = tbkvs.get("alice", 1);
        // System.out.println(get1);

        // String get2 = tbkvs.get("alice", 2);
        // System.out.println(get2);

        // tbkvs.set("alice", "sad", 3);
        // String get3 = tbkvs.get("alice", 3);
        // System.out.println(get3);


        // tbkvs.set("foo", "bar", 1);
        // System.out.println(tbkvs.get("foo", 1));

        // System.out.println(tbkvs.get("foo", 3));

        // tbkvs.set("foo", "bar2", 4);

        // System.out.println(tbkvs.get("foo", 4));

        // System.out.println(tbkvs.get("foo", 5));

        // tbkvs.set("bob", "builder", 2);

        // System.out.println(tbkvs.get("bob", 1));

        // System.out.println(tbkvs.get("bob", 2));

        // System.out.println(tbkvs.get("bob", 3));


        // tbkvs.set("test", "one", 10);
        // tbkvs.set("test", "two", 20);
        // tbkvs.set("test", "three", 30);
        // System.out.println(tbkvs.get("test", 15));
        // System.out.println(tbkvs.get("test", 25));
        // System.out.println(tbkvs.get("test", 35));

        tbkvs.set("extreme", "start", 1);
        tbkvs.set("extreme", "end", 1000);
        System.out.println(tbkvs.get("extreme", 500));
        System.out.println(tbkvs.get("extreme", 1000));
    }
}