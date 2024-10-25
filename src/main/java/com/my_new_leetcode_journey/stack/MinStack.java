package com.my_new_leetcode_journey.stack;

import java.util.Stack;

/**
 * <h1>Minimum Stack</h1>
 * <h2>Medium</h2>
 * <p>
 * Design a stack class that supports the <code>push</code>, <code>pop</code>,
 * <code>top</code>, and <code>getMin</code> operations.
 * </p>
 * <ul>
 * <li><code>MinStack()</code> initializes the stack object.</li>
 * <li><code>void push(int val)</code> pushes the element <code>val</code> onto
 * the stack.</li>
 * <li><code>void pop()</code> removes the element on the top of the stack.</li>
 * <li><code>int top()</code> gets the top element of the stack.</li>
 * <li><code>int getMin()</code> retrieves the minimum element in the
 * stack.</li>
 * </ul>
 * <p>
 * Each function should run in <code>O(1)</code> time.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]
 * Output: [null, null, null, null, 0, null, 2, 1]
 * 
 * Explanation:
 * MinStack minStack = new MinStack();
 * minStack.push(1);
 * minStack.push(2);
 * minStack.push(0);
 * minStack.getMin(); // return 0
 * minStack.pop();
 * minStack.top();    // return 2
 * minStack.getMin(); // return 1
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li><code>-2^31 <= val <= 2^31 - 1</code></li>
 * <li><code>pop</code>, <code>top</code>, and <code>getMin</code> will always
 * be called on non-empty stacks.</li>
 * </ul>
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
