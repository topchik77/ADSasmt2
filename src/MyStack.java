import MyList.*;

/**
 * push: Adds an element to the top of the stack.
 * pop: Removes and returns the element from the top of the stack.
 * peek: Returns the element from the top of the stack without removing it.
 * size: Returns the number of elements currently in the stack.
 */
public class MyStack<T extends Comparable<T>> implements DataType<T>{
    private final MyList<T> list;

    public MyStack(MyList<T> list) {
        this.list = list;
    }

    public void push(T t) {
        list.addLast(t);
    }

    public T pop() {
        T t = list.getLast();
        list.removeLast();
        return t;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.set();
    }
}

