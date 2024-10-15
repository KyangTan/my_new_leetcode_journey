package com.my_new_leetcode_journey.arrays_hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Is Anagram</h1>
 * <h2>Easy</h2>
 * <p>
 * Given two strings <code>s</code> and <code>t</code>, return <code>true</code>
 * if the two strings are anagrams of each other; otherwise, return
 * <code>false</code>.
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
 * Input: s = "racecar", t = "carrace"
 * Output: true
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: s = "jar", t = "jam"
 * Output: false
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li><code>s</code> and <code>t</code> consist of lowercase English
 * letters.</li>
 * </ul>
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        return mapS.equals(mapT);

    }
}
