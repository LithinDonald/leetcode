class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;     // points to the current front element
        rear = -1;     // points to the current rear element
        size = 0;
    }

    // Insert an item at the front
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        if (size == 0) rear = front; // first element inserted
        size++;
        return true;
    }

    // Insert an item at the rear
    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        if (size == 0) front = rear; // first element inserted
        size++;
        return true;
    }

    // Delete an item from the front
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        if (size == 0) rear = front - 1; // reset rear if empty
        return true;
    }

    // Delete an item from the rear
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        if (size == 0) front = rear + 1; // reset front if empty
        return true;
    }

    // Get the front item
    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    // Get the rear item
    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }
}