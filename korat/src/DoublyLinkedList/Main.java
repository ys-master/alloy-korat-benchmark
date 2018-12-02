package DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(new DoublyLinkedList.Node(1));
        dll.add(new DoublyLinkedList.Node(2));
        dll.add(new DoublyLinkedList.Node(3));
        dll.add(new DoublyLinkedList.Node(4));
        dll.add(new DoublyLinkedList.Node(5));

        System.out.println(dll.repOK());
        System.out.println(dll.size);
        System.out.println(dll.toString());

        DoublyLinkedList.Node pointer = dll.header.link.link;
        dll.remove(pointer);

        System.out.println(dll.repOK());
        System.out.println(dll.size);
        System.out.println(dll.toString());

        System.out.println(dll.search(2));
        System.out.println(dll.search(3));
    }
}
