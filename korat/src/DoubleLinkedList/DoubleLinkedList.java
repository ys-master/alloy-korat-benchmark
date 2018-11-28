package DoubleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList {
    public Node header;

    public void add(Node newNode) {
        if (newNode == null) {
            return;
        }

        if (header == null) {
            header = newNode;
        }
        else {
            Node currNode = header;
            while (currNode.link != null) {
                currNode = currNode.link;
            }
            currNode.link = newNode;
            newNode.prev = currNode;
        }
    }

    public void remove(Node node) {
        if (node == null) {
            return;
        }

        if (node == header) {
            header = node.link;
        }
        else {
            node.prev.link = node.link;
            node.link.prev = node.prev;
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

    public boolean repOk() {
        // The list has no directed cycle along link
        Node curr_node = header;
        List<Node> visited = new ArrayList<>();
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
}
