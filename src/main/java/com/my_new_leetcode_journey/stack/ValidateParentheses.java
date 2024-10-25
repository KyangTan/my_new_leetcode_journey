package com.my_new_leetcode_journey.stack;

import java.util.Stack;

public class ValidateParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            }else{
                if(character == ')' ){
                    if(stack.isEmpty() || stack.peek() != '('){
                        return false;
                    }
                    stack.pop();
                }
                if(character == ']' ){
                    if(stack.isEmpty() || stack.peek() != '['){
                        return false;
                    }
                    stack.pop();
                }
                if(character == '}' ){
                    if(stack.isEmpty() || stack.peek() != '{'){
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
