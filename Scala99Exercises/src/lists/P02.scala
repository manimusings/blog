package lists


/*

P02 (*) Find the last but one element of a list.
Example:
scala> penultimate(List(1, 1, 2, 3, 5, 8))
res0: Int = 5

 */


object P02 {
  def penultimate[T](list: List[T]): Option[T] = {
    list match {
      case x1 :: x2 :: Nil => Some(x1)
      case x :: xs => penultimate(xs)
      case _ => None
    }
  }

  def moveTo[T](list: List[T], nth: Int): Option[List[T]] = {
    list match {
      case x :: xs if nth > 0 => moveTo(xs, nth - 1)
      case all if nth == 0 => Some(all)
      case _ => None
    }
  }

  def lastNth[T](list: List[T], nth: Int): Option[T] = {
    def lastNth[T](worker: List[T], marker: List[T]): Option[T] = {
      marker match {
        case x :: Nil => Some(worker.head)
        case x :: xs => lastNth(worker.drop(1), xs)
        case _ => None
      }
    }

//    moveTo(list, Math.abs(nth)).flatMap(lastNth(list, _))
    lastNth(list, list.drop(Math.abs(nth)))
  }

  def main(args: Array[String]): Unit = {
    println(lastNth(List(1, 7, 2, 3, 5, 8), 4))
    //builtin
    println(List(1, 7, 2, 3, 5, 8).dropRight(4).lastOption)
  }
}

