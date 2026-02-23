import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            // maintain decreasing order in maxDeque
            while (!maxDeque.isEmpty() && nums[right] > nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // maintain increasing order in minDeque
            while (!minDeque.isEmpty() && nums[right] < nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // shrink window if limit exceeded
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}