package com.my_new_leetcode_journey.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>Time-Based Key-Value Store</h1>
 * <h2>Medium</h2>
 * <p>
 * This class implements a time-based key-value data structure that allows
 * storing multiple values for
 * the same key at specified timestamps and retrieving the key's value at a
 * given timestamp. The timestamps
 * for each key are assumed to be in strictly increasing order.
 * </p>
 * 
 * <h2>Class Operations:</h2>
 * <ul>
 * <li><code>TimeMap()</code> - Initializes the time-based key-value store
 * object.</li>
 * <li><code>void set(String key, String value, int timestamp)</code> - Stores
 * the <code>key</code> with the <code>value</code> at the given
 * <code>timestamp</code>.</li>
 * <li><code>String get(String key, int timestamp)</code> - Retrieves the most
 * recent value associated with <code>key</code> at a timestamp
 * that is less than or equal to the specified timestamp. Returns an empty
 * string if no such value exists.</li>
 * </ul>
 * 
 * <h3>Example Usage:</h3>
 * 
 * <pre>
 * Input:
 * ["TimeMap", "set", ["alice", "happy", 1], "get", ["alice", 1], "get", ["alice", 2], 
 *  "set", ["alice", "sad", 3], "get", ["alice", 3]]
 * 
 * Output:
 * [null, null, "happy", "happy", null, "sad"]
 * </pre>
 * <p>
 * Explanation:
 * 
 * <pre>
 * TimeMap timeMap = new TimeMap();
 * timeMap.set("alice", "happy", 1); // Stores key "alice" with value "happy" at timestamp 1.
 * timeMap.get("alice", 1); // Returns "happy".
 * timeMap.get("alice", 2); // Returns "happy", as no value for timestamp 2 is found.
 * timeMap.set("alice", "sad", 3); // Stores key "alice" with value "sad" at timestamp 3.
 * timeMap.get("alice", 3); // Returns "sad".
 * </pre>
 * </p>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li><code>1 <= key.length, value.length <= 100</code></li>
 * <li><code>key</code> and <code>value</code> consist of lowercase English
 * letters and digits only.</li>
 * <li><code>1 <= timestamp <= 1000</code></li>
 * </ul>
 *
 * @param key       the key associated with the value
 * @param value     the value to store for the specified key and timestamp
 * @param timestamp the time at which the key-value pair is stored
 * @return the value associated with the key at the specified timestamp or the
 *         most recent previous timestamp
 */
public class TimeBasedKeyValueStore {
    Map<String, ArrayList<String>> valueMap;

    public TimeBasedKeyValueStore() {
        valueMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (valueMap.containsKey(key)) {
            ArrayList<String> valueArray = valueMap.get(key);
            int size = valueArray.size();
            if (timestamp > size) {
                while (size != timestamp - 1) {
                    valueArray.add("");
                    size = valueArray.size();
                }
                valueArray.add(value);
            }
        } else {
            ArrayList<String> valueArray = new ArrayList<>();
            int size = valueArray.size();
            if (timestamp > size) {
                while (size != timestamp - 1) {
                    valueArray.add("");
                    size = valueArray.size();
                }
                valueArray.add(value);
            }
            valueMap.put(key, valueArray);
        }
    }

    public String get(String key, int timestamp) {
        ArrayList<String> valueArray = valueMap.getOrDefault(key, new ArrayList<>());

        if (valueArray.equals(null) || valueArray.isEmpty()) {
            return "";
        }

        String answer = "";

        if (timestamp >= valueArray.size()) {
            answer = valueArray.get(valueArray.size() - 1);
        } else if (timestamp == 0) {
            return "";
        } else {
            int i = timestamp;
            System.out.println(i);
            do {
                i--;
                answer = valueArray.get(i);
            } while (answer.equals("") && i > 0);
        }
        return answer;
    }
}
