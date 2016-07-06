package lists



/*

P11 (*) Modified run-length encoding.
Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

 */


object P11 {


  def encode[T](list: List[T]): List[Any] = {
    def decode[T](item: (Int, T)): Any = {
      if (item._1 < 2) item._2
      else item
    }
    def encode[T](list: List[T], group: Option[(Int, T)]): List[Any] = {
      list match {
        case x :: xs if group.nonEmpty && group.get._2 == x => encode(xs, Some((group.get._1 + 1, group.get._2)))
        case x :: xs if group.nonEmpty => decode(group.get) :: encode(xs, Some((1, x)))
        case x :: xs => encode(xs, Some((1, x)))
        case _ if group.nonEmpty => decode(group.get) :: Nil
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

