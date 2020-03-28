public class SimpleStack {
    private static class Node {
        private int data;
        private SimpleStack.Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        int data = 0;
        if (top != null)
            data = top.data;
        return data;
    }

    public void push(int data) {
        Node n = new Node(data);
        if (top != null) {
            n.next = top; // store the current top
            top = n;
        } else {
            // top is null new element
            top = n;
        }

    }

    public int pop() {
        int data = 0;
        if (top != null) {
            data = top.data;
            top = top.next;
        } else {
            //throw some error
        }
        return data;

    }
}
