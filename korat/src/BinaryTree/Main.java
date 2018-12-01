package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.root = new BinaryTree.Node(1);
        bt.root.left = new BinaryTree.Node(2);
        bt.root.right = new BinaryTree.Node(3);
        bt.root.left.left = new BinaryTree.Node(4);

        System.out.println(bt.repOK());

        bt.root.left.right = bt.root.left;

        System.out.println(bt.repOK());
    }
}
