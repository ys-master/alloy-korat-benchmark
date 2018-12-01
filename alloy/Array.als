sig Element {}

one sig Array {
  // Maps indexes to elements of Element.
  i2e: Int -> Element,
  // Represents the length of the array.
  length: Int
}

// Assume all objects are in the array.
fact Reachable {
  Element = Array.i2e[Int]
}

// Part (a)
fact InBound {
  // All indexes should be greater than or equal to 0 and less than
  // the array length.
  -- TODO: Your code starts here.
	all n: Element[Array.i2e] | n >=0 and n < Array.length

  // Array length should be greater than or equal to 0.
  -- TODO: Your code starts here.
	Array.length >=0
}

// Part (b)
pred NoConflict() {
  // Each index maps to at most one element.
  -- TODO: Your code starts here.

	all n: Element[Array.i2e] | #Array.i2e[n] <= 1
}

run NoConflict for 10
