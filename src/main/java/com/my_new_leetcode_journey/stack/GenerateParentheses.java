package com.my_new_leetcode_journey.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    public static List<String> generateParenthesisRecursive(int n) {
        List<String> answer = new ArrayList<String>();
        Stack<Character> stack = new Stack<>();

        backtrack(3, 0, 0, stack, answer);

        return answer;
    }

    private static void backtrack(int n, int openN, int closeN, Stack<Character> stack, List<String> answer) {
        if (openN == closeN && openN == n) {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            answer.add(sb.toString());
            return;
        }

        if (openN < n) {
            stack.push('(');
            backtrack(n, openN + 1, closeN, stack, answer);
            stack.pop();
        }
        if (closeN < openN) {
            stack.push(')');
            backtrack(n, openN, closeN + 1, stack, answer);
            stack.pop();
        }
    }

}
