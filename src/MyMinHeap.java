public class MyMinHeap<T extends Comparable<T>> {
    private T[] heap;
    private int size;

    public MyMinHeap(T[] arr) {
        this.heap = arr;
        this.size = arr.length;
        buildHeap();
    }

    private void heapify(int i) {
        int smallest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left].compareTo(heap[smallest]) < 0) {
            smallest = left;
        }
        if (right < size && heap[right].compareTo(heap[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }


    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public T extractMin() {
        if (size <= 0) {
            return null;
        }
        T min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    public T getMin()  {
        if (size <= 0) {
            return null;
        }
        return heap[0];
    }

    public void printHeap() {
        System.out.println("Array representation of Heap is:");
        for (int i =0; i < size; ++i ) {
            System.out.print( heap[i] + " " );
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        MyMinHeap<Integer> heap = new MyMinHeap<>(arr);
        heap.printHeap();

        System.out.println("Min element: " + heap.getMin());
        System.out.println("Extracted min element: " + heap.extractMin());
        heap.printHeap();
    }
}

