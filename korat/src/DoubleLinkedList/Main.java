package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add(new DoubleLinkedList.Node(1));
        dll.add(new DoubleLinkedList.Node(2));
        dll.add(new DoubleLinkedList.Node(3));
        dll.add(new DoubleLinkedList.Node(4));
        dll.add(new DoubleLinkedList.Node(5));

        System.out.println(dll.repOK());
        System.out.println(dll.size);
        System.out.println(dll.toString());

        DoubleLinkedList.Node pointer = dll.header.link.link;
        dll.remove(pointer);

        System.out.println(dll.repOK());
        System.out.println(dll.size);
        System.out.println(dll.toString());

        System.out.println(dll.search(2));
        System.out.println(dll.search(3));
    }
}
