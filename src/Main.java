public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("arrayList size: " + arrayList.size());
        System.out.println("arrayList elements: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("\nlinkedList size: " + linkedList.size());
        System.out.println("linkedList elements: ");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("\nqueue size: " + queue.size());
        System.out.println("queue elements: ");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("\nstack size: " + stack.size());
        System.out.println("stack elements: ");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Integer[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        MyMinHeap<Integer> heap = new MyMinHeap<>(arr);
        heap.printHeap();

        System.out.println("min element:  " + heap.getMin());
        System.out.println("extract min element: " + heap.extractMin());
        heap.printHeap();
        }

    }
}