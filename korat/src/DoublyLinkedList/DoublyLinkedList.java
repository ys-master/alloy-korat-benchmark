package DoublyLinkedList;

import korat.finitization.IFinitization;
import korat.finitization.IIntSet;
import korat.finitization.IObjSet;
import korat.finitization.impl.FinitizationFactory;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    public static class Node {
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

    public Node header;
    public int size = 0;

    public void add(Node newNode) {
        if (newNode == null) {
            return;
        }

        if (header == null) {
            header = newNode;
            size += 1;
        }
        else {
            Node currNode = header;
            while (currNode.link != null) {
                currNode = currNode.link;
            }
            currNode.link = newNode;
            newNode.prev = currNode;
            size += 1;
        }
    }

    public void remove(Node node) {
        if (node == null) {
            return;
        }

        if (node == header) {
            header = node.link;
            size -= 1;
        }
        else {
            node.prev.link = node.link;
            node.link.prev = node.prev;
            size -= 1;
        }
    }

    public Node search(int elem) {
        Node pointer = header;
        while (pointer != null) {
            if (pointer.elem == elem) {
                return pointer;
            }
            pointer = pointer.link;
        }
        return null;
    }

    public boolean repOK() {
        // The list has no directed cycle along link
        Node curr_node = header;
        List<Node> visited = new ArrayList<Node>();
        while (curr_node != null) {
            if (visited.contains(curr_node)) {
                return false;
            }
            else {
                visited.add(curr_node);
                curr_node = curr_node.link;
            }
        }

        // Predicate for a Double Linked List
        // 1.For any node n1 and n2, if n1.link = n2, then n2.prev = n1; and vice versa.
        curr_node = header;
        while (curr_node != null) {
            Node next_node = curr_node.link;
            if (next_node != null) {
                if (next_node.prev != curr_node) {
                    return false;
                }
            }
            curr_node = curr_node.link;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Node currNode = header;
        while (currNode != null) {
            stringBuilder.append(currNode.elem);
            currNode = currNode.link;
            if (currNode != null) {
                stringBuilder.append(" -> ");
            }
        }

        return stringBuilder.toString();
    }

    public static IFinitization finDoublyLinkedList(int size) {
        return finDoublyLinkedList(size, 1, size, size);
    }

    public static IFinitization finDoublyLinkedList(int nodesNum,
                                                    int values,
                                                    int minSize,
                                                    int maxSize) {
        IFinitization f = FinitizationFactory.create(DoublyLinkedList.class);
        IObjSet nodes = f.createObjSet(Node.class, nodesNum, true);
        IIntSet intValues = f.createIntSet(values);
        IIntSet sizes = f.createIntSet(minSize, maxSize);
        f.set("header", nodes);
        f.set("Node.prev", nodes);
        f.set("Node.link", nodes);
        f.set("Node.elem", intValues);
        f.set("size", sizes);
        return f;
    }
}
