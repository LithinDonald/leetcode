import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = Arrays.copyOf(prices, n);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = prices[prevIndex] - prices[i];
            }
            stack.push(i);
        }

        return answer;
    }
}