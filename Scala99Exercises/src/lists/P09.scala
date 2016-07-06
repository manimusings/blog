package lists

/*

P09 (**) Pack consecutive duplicates of list elements into sublists.
If a list contains repeated elements they should be placed in separate sublists.
Example:

scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

 */


object P09 {


  //  def compress[T](list: List[T]): List[List[T]] = {
  //    @tailrec
  //    def compress[T](list: List[T], group: List[T], result: List[List[T]]): List[List[T]] = {
  //      list match {
  //        case x :: xs if group.nonEmpty && group.head == x => compress(xs, x :: group, result)
  //        case x :: xs if group.nonEmpty => compress(xs, List(x), result :+ group)
  //        case x :: xs => compress(xs, List(x), result)
  //        case _ if group.nonEmpty => result :+ group
  //        case _ => result
  //      }
  //    }
  //
  //    compress(list, Nil, Nil)
  //  }

  // AMI: The above solution is tailrecursive but the following solution
  // is probably more elegant but it is not tailrecursive
  def compress[T](list: List[T]): List[List[T]] = {
    def compress[T](list: List[T], group: List[T]): List[List[T]] = {
      list match {
        case x :: xs if group.nonEmpty && group.head == x => compress(xs, x :: group)
        case x :: xs if group.nonEmpty => group :: compress(xs, List(x))
        case x :: xs => compress(xs, List(x))
        case _ => group :: Nil
      }
    }

    compress(list, Nil)
  }

  def main(args: Array[String]): Unit = {
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(compress(List('a, 'b, 'c, 'd, 'e)))
    println(compress(List('a)))
    println(compress(List('a, 'b, 'b, 'c, 'c, 'c, 'd, 'd, 'd, 'd, 'e, 'e, 'e, 'e, 'e)))
    println(compress(Nil))
    println(compress(null))
  }
}

