import java.util.Iterator;
/**
 * A doubly linked list implementation of the MyList interface. It allows for adding,
 * removing, and accessing elements in the list, as well as checking for the existence
 * of an element and getting the size of the list.
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addElement(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail= newNode;

        }
        size++;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        Node<T> current = getNodeAtIndex(index, head);
        current.data = item;
    }


    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == size) {
            addElement(item);
        } else {
            Node<T> newNode = new Node<>(item);
            Node<T> current = getNodeAtIndex(index, head);
            newNode.prev = current.prev;
            newNode.next = current;
            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;
            }
            current.prev = newNode;
            size++;
        }
    }


    @Override
    public void addFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        addElement(item);
    }

    public T get(int index) {
        checkIndex(index);
        return getNodeAtIndex(index, head).data;
    }

    private Node<T> getNodeAtIndex(int index, Node<T> node) {
        if (index == 0) {
            return node;
        }
        return getNodeAtIndex(index - 1, node.next);
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }
    
    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node<T> node = getNodeAt(index - 1);
        node.next = node.next.next;
        size--;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        size--;
    }

    @Override
    public void removeLast() {
        Node<T> node = getNodeAt(size - 2);
        node.next = null;
        size--;
    }

    private Node<T> getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void sort() {
        boolean swapped;
        Node<T> node;

        if (head == null)
            return;

        do {
            swapped = false;
            node = head;

            while (node.next != null) {
                if (((Comparable<T>) node.data).compareTo(node.next.data) > 0) {
                    T t = node.next.data;
                    node.next.data = node.data;
                    node.data = t;
                    swapped = true;
                }
                node = node.next;
            }
        } while (swapped);
    }



    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        int i = 0;
        Node<T> current = head;

        while (current != null) {
            newArray[i] = current.data;
            current = current.next;
            i++;
        }

        return newArray;
    }

    public int indexOf(Object object) {
        if (isEmpty()) {
            return -1;
        }
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (object == null) {
                if (current.data == null) {
                    return index;
                }
            } else {
                if (object.equals(current.data)) {
                    return index;
                }
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        if (isEmpty()) {
            return -1;
        }
        int index = size - 1;
        Node<T> current = tail;
        while (current != null) {
            if (object == null) {
                if (current.data == null) {
                    return index;
                }
            } else {
                if (object.equals(current.data)) {
                    return index;
                }
            }
            index--;
            current = current.prev;
        }
        return -1;
    }

}
