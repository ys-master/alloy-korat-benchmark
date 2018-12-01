one sig BinaryTree {
  header: lone Node
}

sig Node {
  left, right: lone Node,
  elem: Int
}

// Assume all objects are in the Binary Tree
fact Reachable {
  Node = BinaryTree.header.*(left+right)
}

fact IntegerLimit {
  all n: Node | n.elem >= 0 and n.elem <= 3
}

// The list has no directed cycle along link
fact Acyclic {
  all n: BinaryTree.header.*(left+right) | n not in n.^(left+right)
}

pred DifferentLeftRight() {
  all n: Node | (n.right != n.left) iff (#n.right != 0 and #n.left !=0)
}

pred RepOk() {
  // Predicate for a Binary Tree
  DifferentLeftRight
}

run RepOk for 13

