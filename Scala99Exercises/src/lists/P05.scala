package lists


/*

P05 (*) Reverse a list.
Example:
scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)

 */


object P05 {

  def reverse[T](list: List[T]): List[T] = {
    def rev[T](list: List[T], reversed: List[T]): List[T] = {
      list match {
        case x :: xs => rev(xs, x +: reversed)
        case Nil => reversed
        case _ => list
      }
    }
    rev(list, List.empty[T])
  }


  def main(args: Array[String]): Unit = {
    println(reverse(List(1, 7, 2, 3, 5, 8)))
    println(reverse(List(1)))
    println(reverse(null))
    //builtin
    println(List(1, 7, 2, 3, 5, 8).reverse)
  }
}

