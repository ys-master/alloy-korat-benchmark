//It should have one header as a starting Node, it can link to another Node or null.
one sig SLL { 
	header: lone Node 
}

//Node has a link which can be another Node or null.
sig Node { 
	link: lone Node 
}

//There should be no cycle.
pred acyclic (l : SLL) {
        all n : l.header.*link | n !in n.^link
}

fact {
        SLL.header.*link = Node
}

run acyclic for 10


