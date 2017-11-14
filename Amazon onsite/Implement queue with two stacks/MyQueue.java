import java.util.Stack;
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void offer(int x) {
        s1.push(x);
    }

    int poll() {
        if (this.empty()) {
            System.out.print("empty queue!");
            return 0;
        }
        if (!s2.empty()) {
            return s2.pop();
        } else {
            while (s1.size() > 1) {
                s2.push(s1.pop());
            }
            return s1.pop();
        }
    }

    int peek() {
        if (this.empty()) {
            System.out.print("empty queue!");
            return 0;
        }
        if (!s2.empty()) {
            return s2.peek();
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }
    }

    boolean empty() {
        return s1.empty() && s2.empty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.offer(1);
        q.offer(2);
        System.out.println(q.poll());
        System.out.println(q.peek());
        q.poll();
        System.out.println(q.empty());
    }
}