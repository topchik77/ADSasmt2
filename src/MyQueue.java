public class MyQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    public T size() {
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
    }

    public boolean offer(T item) {
        try {
            add(item);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public void add(T item) {
        if (!offer(item)) {
            throw new IllegalStateException("Queue is full");
        }
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    public T element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return head.data;
    }
}
