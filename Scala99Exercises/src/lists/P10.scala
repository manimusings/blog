package lists



/*

P10 (*) Run-length encoding of a list.
Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
Example:

scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

 */


object P10 {


  def encode[T](list: List[T]): List[(Int, T)] = {
    def encode[T](list: List[T], group: Option[(Int, T)]): List[(Int, T)] = {
      list match {
        case x :: xs if group.nonEmpty && group.get._2 == x => encode(xs, Some((group.get._1 + 1, group.get._2)))
        case x :: xs if group.nonEmpty => group.get :: encode(xs, Some((1, x)))
        case x :: xs => encode(xs, Some((1, x)))
        case _ if group.nonEmpty => group.get :: Nil
        case _ => Nil
      }
    }

    encode(list, None)
  }

  def main(args: Array[String]): Unit = {
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(encode(List('a, 'b, 'c, 'd, 'e)))
    println(encode(List('a)))
    println(encode(List('a, 'b, 'b, 'c, 'c, 'c, 'd, 'd, 'd, 'd, 'e, 'e, 'e, 'e, 'e)))
    println(encode(Nil))
    println(encode(null))
  }
}

