package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.add(new Node(1));
        dll.add(new Node(2));
        dll.add(new Node(3));
        dll.add(new Node(4));
        dll.add(new Node(5));

        System.out.println(dll.repOk());
        System.out.println(dll.toString());

        Node pointer = dll.header.link.link;
        dll.remove(pointer);

        System.out.println(dll.repOk());
        System.out.println(dll.toString());

        System.out.println(dll.search(2));
        System.out.println(dll.search(3));
    }
}
