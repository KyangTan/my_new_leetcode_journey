package com.my_new_leetcode_journey.stack;

import java.util.Stack;

/**
 * <h1>Evaluate Reverse Polish Notation</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given an array of strings <code>tokens</code> that represents a valid
 * arithmetic expression in Reverse Polish Notation.
 * </p>
 * <p>
 * Return the integer that represents the evaluation of the expression.
 * </p>
 * <ul>
 * <li>The operands may be integers or the results of other operations.</li>
 * <li>The operators include <code>'+'</code>, <code>'-'</code>,
 * <code>'*'</code>, and <code>'/'</code>.</li>
 * <li>Assume that division between integers always truncates toward zero.</li>
 * </ul>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: tokens = ["1", "2", "+", "3", "*", "4", "-"]
 * Output: 5
 * 
 * Explanation: ((1 + 2) * 3) - 4 = 5
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>1 <= tokens.length <= 1000</li>
 * <li><code>tokens[i]</code> is <code>"+"</code>, <code>"-"</code>,
 * <code>"*"</code>, <code>"/"</code>, or a string representing an integer in
 * the range [-100, 100].</li>
 * </ul>
 */
public class EvaluateReversePolishNotation {

    public int evalRPNOptimized(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push((int) ((double) b / a));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public int evalRPN(String[] tokens) {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            System.out.println(token);
            char[] tokenChar = token.toCharArray();

            boolean checkIsDigit = false;
            for (char charToCheck : tokenChar) {
                if (!Character.isDigit(charToCheck)) {
                    checkIsDigit = false;
                } else {
                    checkIsDigit = true;
                }
            }

            if (checkIsDigit) {
                stack.push(token);
            } else {
                int number1 = Integer.valueOf(stack.pop());
                int number2 = Integer.valueOf(stack.pop());
                if (token.equals("+")) {
                    answer = number2 + number1;
                }
                if (token.equals("-")) {
                    answer = number2 - number1;
                }
                if (token.equals("*")) {
                    answer = number2 * number1;
                }
                if (token.equals("/")) {
                    System.out.println("n1 " + number1);
                    System.out.println("n2" + number2);
                    answer = number2 / number1;
                }
                stack.push(String.valueOf(answer));
            }
        }
        if (!stack.isEmpty()) {
            answer = Integer.valueOf(stack.pop());
        }
        return answer;
    }
}
