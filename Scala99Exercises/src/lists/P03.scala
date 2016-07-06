package lists


/*

P03 (*) Find the Kth element of a list.
By convention, the first element in the list is element 0.
Example:

scala> nth(2, List(1, 1, 2, 3, 5, 8))
res0: Int = 2

 */


object P03 {

  def moveTo[T](list: List[T], nth: Int): Option[List[T]] = {
    list match {
      case x :: xs if nth > 0 => moveTo(xs, nth - 1)
      case all if nth == 0 => Some(all)
      case _ => None
    }
  }

  def kth[T](list: List[T], k: Int): Option[T] = {
    moveTo(list, k).flatMap(_.headOption)
  }


  def main(args: Array[String]): Unit = {
    println(kth(List(1, 7, 2, 3, 5, 8), 4))
    //builtin
    println(List(1, 7, 2, 3, 5, 8).drop(4).headOption)
  }
}

