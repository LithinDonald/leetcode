import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Step 3: Count how many tasks have the maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // Step 4: Calculate minimum intervals using the formula
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.leastInterval(new char[] {'A','A','A','B','B','B'}, 2)); // Output: 8
        System.out.println(sol.leastInterval(new char[] {'A','C','A','B','D','B'}, 1)); // Output: 6
        System.out.println(sol.leastInterval(new char[] {'A','A','A','B','B','B'}, 3)); // Output: 10
    }
}