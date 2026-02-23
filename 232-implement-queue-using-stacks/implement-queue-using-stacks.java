import java.util.*;

class MyQueue {
    private Deque<Integer> stackPush;
    private Deque<Integer> stackPop;

    public MyQueue() {
        stackPush = new ArrayDeque<>();
        stackPop = new ArrayDeque<>();
    }

    public void push(int x) {
        stackPush.push(x);
    }

    private void shiftStacks() {
        if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }

    public int pop() {
        shiftStacks();
        return stackPop.pop();
    }

    public int peek() {
        shiftStacks();
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}