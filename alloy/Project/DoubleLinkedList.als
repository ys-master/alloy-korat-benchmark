one sig DLL {
  header: lone Node
}

sig Node {
  prev, link: lone Node,
  elem: Int
}

// Assume all objects are in the Double Linked List
fact Reachable {
  Node = DLL.header.*link
}

// The list has no directed cycle along link
fact Acyclic {
  all n: DLL.header.*link | n not in n.^link
}

pred RepOk() {
  // Predicate for a Double Linked List
  // 1.For any node n1 and n2, if n1.link = n2, then n2.prev = n1; and vice versa.
  all n1, n2: Node | n2.prev = n1 iff n1.link = n2
}

run RepOk for 3

