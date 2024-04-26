public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.addElement(1);
        myLinkedList.addElement(2.5);
        myLinkedList.addElement(3);
        myLinkedList.addElement(4.7);
        myLinkedList.addElement('A');

        System.out.println("Index of an index 3:" + myLinkedList.getData(3));
        myLinkedList.remove(3);
        System.out.println("Index of an index 3:" + myLinkedList.getData(3));
    }
}