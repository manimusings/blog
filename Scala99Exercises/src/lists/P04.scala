package lists


/*

P04 (*) Find the number of elements of a list.
Example:
scala> length(List(1, 1, 2, 3, 5, 8))
res0: Int = 6

 */


object P04 {

  def length[T](list: List[T]): Int = {
    def len[T](list: List[T], lt: Int): Int = {
      list match {
        case x :: xs => len(xs, lt + 1)
        case Nil => lt
        case _ => -1
      }
    }
    len(list, 0)
  }


  def main(args: Array[String]): Unit = {
    println(length(List(1, 7, 2, 3, 5, 8)))
    println(length(List(1)))
    println(length(null))
    //builtin
    println(List(1, 7, 2, 3, 5, 8).length)
  }
}

