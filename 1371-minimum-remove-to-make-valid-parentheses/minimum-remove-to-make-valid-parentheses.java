import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // First pass: find invalid parentheses
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toRemove.add(i);
                }
            }
        }

        // Add remaining unmatched '('
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}