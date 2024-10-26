package com.my_new_leetcode_journey;

import java.util.List;

import com.my_new_leetcode_journey.stack.EvaluateReversePolishNotation;
import com.my_new_leetcode_journey.stack.GenerateParentheses;
import com.my_new_leetcode_journey.stack.ValidateParentheses;
import com.my_new_leetcode_journey.two_pointers.MaxWaterContainer;

public class Main {
    public static void main(String[] args) {
        // String[] nums = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        // int answer = MaxWaterContainer.maxAreaSelfAttempt(nums);

        // System.out.println(answer);

        // List<List<Integer>> answer = ThreeIntegerSum.threeSumSelfAttempt(nums);

        // System.out.print("answer: [");
        // for (int i : answer) {
        //     System.out.print(i);
        // }
        // System.out.print("answer: ]");

        // EvaluateReversePolishNotation erpn = new EvaluateReversePolishNotation();

        // erpn.evalRPN(nums);

        int n = 3;

        List<String> answer = GenerateParentheses.generateParenthesisRecursive(n);

        System.out.println();

        System.out.println("Answer : " + answer);


    }
}