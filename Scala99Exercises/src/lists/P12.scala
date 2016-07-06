package lists



/*

P12 (**) Decode a run-length encoded list.
Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

 */


object P12 {


  def decode[T](list: List[(Int, T)]): List[T] = {

    list match {
      case (count: Int, item: T) :: xs => List.fill(count)(item) ++ decode(xs)
      case _ => Nil
    }

  }

  def main(args: Array[String]): Unit = {
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
    println(decode(Nil))
    println(decode(null))
  }
}

