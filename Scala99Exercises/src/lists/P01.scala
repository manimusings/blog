package lists


/*

P01 (*) Find the last element of a list.
Example:
scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8

 */


object P01 {
  def last[T](list: List[T]): Option[T] = {
    list match {
      case x :: Nil => Some(x)
      case x :: xs => last(xs)
      case _ => None
    }
  }

  def main(args: Array[String]): Unit = {
    println(last(List(1, 1, 2, 3, 5, 8)));
  }
}

