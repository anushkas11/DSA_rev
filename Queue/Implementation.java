class myQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    // Constructor
    public myQueue(int n) {
        capacity = n;
        arr = new int[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Enqueue an element
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity; // circular increment
        arr[rear] = x;
        size++;
    }

    // Dequeue an element
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        front = (front + 1) % capacity; // circular increment
        size--;
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Get last element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[rear];
    }
}
