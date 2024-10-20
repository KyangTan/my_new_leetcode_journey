package com.my_new_leetcode_journey.two_pointers;

import java.util.Stack;

/**
 * <h1>Is Palindrome</h1>
 * <h2>Easy</h2>
 * <p>
 * Given a string <code>s</code>, return <code>true</code> if it is a palindrome, otherwise return <code>false</code>.
 * </p>
 * <p>
 * A palindrome is a string that reads the same forward and backward. It is case-insensitive and ignores all non-alphanumeric characters.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * <pre>
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * <pre>
 * Input: s = "tab a cat"
 * Output: false
 * Explanation: "tabacat" is not a palindrome.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 *   <li>1 <= s.length <= 1000</li>
 *   <li><code>s</code> is made up of only printable ASCII characters.</li>
 * </ul>
 */
public class ValidPalindrome {

    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <ul>
     *     <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1)</p>
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(left < right) {
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }


    /**
     * <h3>Time & Space Complexity:</h3>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <ul>
     *     <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(n)</p>
     * <ul>
     *     <li>Where <code>n</code> is the length of the input.</li>
     * </ul>
     */
    public static boolean isPalindromeStack(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                stack.push(Character.toLowerCase(c));
            }
        }

        for (char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                if(stack.pop() != Character.toLowerCase(c)) {
                    return false;
                }
            }
        }

        return true;

    }
    


}
