package sree.datastructures;

public class SimpleQueue {

    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head; //remove from the head
    private Node tail; // add here

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() throws Exception {
        if (head != null) {
            return head.data;
        } else {
            throw new Exception("Empty ");
        }
    }

    public void add(int data) {
        Node n = new Node(data);
        if (tail != null) {
            tail.next = n;
        }
        tail = n;
        if (head == null)
            head = n;
    }

    public int remove() throws Exception {
        int data = 0;
        if (head != null) {
            data = head.data;
        } else {
            throw new Exception("Empty ");
        }
        head = head.next;
        if (head == null) // if head now becomes null after the removal , then tail should also be null
            tail = null;

        return data;
    }

}
