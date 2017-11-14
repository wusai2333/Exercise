import java.util.LinkedList;

class MyStack {
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    void push(int x) {
        queue.offer(x);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    int pop() {
        return queue.poll();
    }

    int top() {
        return queue.peek();
    }

    boolean empty() {
        return queue.isEmpty();
    }
}