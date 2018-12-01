sig Element {
  value: Int
}

one sig HeapArray {
	// maps index to elements 
	i2e: Int -> Element,
	length: Int,
	// actual size of the array 
	size: Int
}



fact Reachable {
	Element = HeapArray.i2e[Int]
}

fact InBound {
	all idx: HeapArray.i2e.Element | idx >= 0 && idx < HeapArray.length
	HeapArray.length >= 0
}

pred RepOk {
	// Each idx maps to one element 
	all idx: HeapArray.i2e.Element | lone HeapArray.i2e[idx]
	// 0 <= size <= length
	all size: HeapArray.size | size >= 0 && size <= HeapArray.length
	// All element != -1
	all idx: HeapArray.i2e.Element | idx < HeapArray.size => HeapArray.i2e[idx].value != -1
	// For every node other than root 
	all idx: HeapArray.i2e.Element | idx != 0 => HeapArray.i2e[div[(idx-1),2]].value >= HeapArray.i2e[idx].value
	all idx: HeapArray.i2e.Element | idx >= HeapArray.size => HeapArray.i2e[idx].value = -1
}

run RepOk for 20

