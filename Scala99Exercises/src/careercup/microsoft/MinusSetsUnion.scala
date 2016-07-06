package careercup.microsoft

/*

Given two sets of strings A and B. Find the
(A-B) U (B-A) ( U = union ). The answer should be in lexicographical order and A’s elements should appear before B’s.

 */

object MinusSetsUnion {

  def minus(a: Seq[String], b: Seq[String]): Seq[String] = {
    a.filter(!b.contains(_))
  }


  //A-B will only selects elments in A and no common elements
  //B-A will only selects elments in D and no common elements
  // so a union of the above step amounts to a simple concatenation
  def main(args: Array[String]): Unit = {
    val a = Set("one", "two", "three")
    val b = Set("four", "three", "five", "six")
    val aMinusb = minus(a.toSeq.sorted, b.toSeq.sorted)
    val bMinusa = minus(b.toSeq.sorted, a.toSeq.sorted)
    val union = aMinusb ++ bMinusa
    println(union)
    //  println(SortedSet(b))
  }

}

