package com.my_new_leetcode_journey.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>String Encode and Decode</h1>
 * <h2>Medium</h2>
 * <p>
 * Design an algorithm to encode a list of strings to a single string. The
 * encoded string
 * is then decoded back to the original list of strings.
 * </p>
 * <p>
 * Please implement <code>encode</code> and <code>decode</code>.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: ["neet", "code", "love", "you"]
 * Output: ["neet", "code", "love", "you"]
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: ["we", "say", ":", "yes"]
 * Output: ["we", "say", ":", "yes"]
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>0 <= strs.length &lt; 100</li>
 * <li>0 <= strs[i].length &lt; 200</li>
 * <li><code>strs[i]</code> contains only UTF-8 characters.</li>
 * </ul>
 */
public class EncodeAndDecodeString {
    public static String encode(List<String> strs) {
        StringBuilder encodedStringBuilder = new StringBuilder();

        for (String string : strs) {
            encodedStringBuilder.append(string.length()).append('#').append(string);
        }
        return encodedStringBuilder.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;

            list.add(str.substring(j + 1, i));

        }

        return list;
    }
}
