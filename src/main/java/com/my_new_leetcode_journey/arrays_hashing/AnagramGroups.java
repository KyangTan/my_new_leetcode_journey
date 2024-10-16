package com.my_new_leetcode_journey.arrays_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>Anagram Groups</h1>
 * <h2>Medium</h2>
 * <p>
 * Given an array of strings <code>strs</code>, group all anagrams together into
 * sublists.
 * You may return the output in any order.
 * </p>
 * <p>
 * An anagram is a string that contains the exact same characters as another
 * string,
 * but the order of the characters can be different.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: strs = ["act", "pots", "tops", "cat", "stop", "hat"]
 * Output: [["hat"], ["act", "cat"], ["stop", "pots", "tops"]]
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: strs = ["x"]
 * Output: [["x"]]
 * </pre>
 * 
 * <h3>Example 3:</h3>
 * 
 * <pre>
 * Input: strs = [""]
 * Output: [[""]]
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li>1 <= strs.length <= 1000</li>
 * <li>0 <= strs[i].length <= 100</li>
 * <li><code>strs[i]</code> is made up of lowercase English letters.</li>
 * </ul>
 */
public class AnagramGroups {

    /**
     *
     * <p>
     * <b>Time Complexity:</b> O(m * n log n)
     * </p>
     *
     * <p>
     * <b>Space Complexity:</b> O(m * n)
     * </p>
     * <ul>
     * <li>Where <code>m</code> is the number of strings.</li>
     * <li>Where <code>n</code> is the length of the longest string.</li>
     * </ul>
     */

    public static List<List<String>> groupAnagramsSorting(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            res.putIfAbsent(sortedString, new ArrayList<>());
            res.get(sortedString).add(s);
        }

        return new ArrayList<>(res.values());
    }

    /**
     * <p>
     * <b>Time Complexity:</b> O(m * n)
     * </p>
     *
     * <p>
     * <b>Space Complexity:</b> O(m)
     * </p>
     * <ul>
     * <li>Where <code>m</code> is the number of strings.</li>
     * </ul>
     */
    public static List<List<String>> groupAnagramsHashTable(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
