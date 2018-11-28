package DoubleLinkedList;

public class Node {
    public Node prev = null, link = null;
    public int elem;

    public Node(int value) {
        elem = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "elem=" + elem +
                '}';
    }
}
