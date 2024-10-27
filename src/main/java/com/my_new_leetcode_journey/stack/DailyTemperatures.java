package com.my_new_leetcode_journey.stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
                int indexStackNumber = indexStack.pop();
                stack.pop();
                int length = i - indexStackNumber;
                answer[indexStackNumber] = length;
            }
            stack.push(temperatures[i]);
            indexStack.push(i);
        }
        return answer;
    }
}
