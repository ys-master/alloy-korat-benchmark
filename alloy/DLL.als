one sig DLL {
  header: lone Node
}

sig Node {
  prev, link: lone Node,
  elem: Int
}

// All nodes are reachable from the header along the link.
fact Reachable {
  Node = DLL.header.*link
}

// Part (a)
fact Acyclic {
  // The list has no directed cycle along link, i.e., no node is
  // reachable from itself following one or more traversals along link.
  -- TODO: Your code starts here.
	all n: DLL.header.*link | n not in n.^link
}

// Part (b)
pred UniqueElem() {
  // Unique nodes contain unique elements.
  -- TODO: Your code starts here.
	all n1, n2: Node | n1 = n2 or n1.elem != n2.elem
}

// Part (c)
pred Sorted() {
  // The list is sorted in ascending order (<=) along link.
  -- TODO: Your code starts here.
	all n: DLL.header.*link | n.elem < n.link.elem
}

// Part (d)
pred ConsistentPrevAndLink() {
  // For any node n1 and n2, if n1.link = n2, then n2.prev = n1; and vice versa.
  -- TODO: Your code starts here.
	all n1, n2: Node | n2.prev = n1 iff n1.link = n2
}

pred RepOk() {
  UniqueElem
  Sorted
  ConsistentPrevAndLink
}

run RepOk for 3

