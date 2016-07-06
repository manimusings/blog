package lists


/*

P07 (**) Flatten a nested list structure.
Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)

 */


object P07 {

  def flattenBuiltIn[T](list: List[List[T]]): List[T] = {
    list.flatten
  }

  // This mirrors buildin flattens behavior
  def flatten[T](list: List[List[T]]): List[T] = {
    for {
      listItem <- list
      item <- listItem
    } yield item
  }

  // This flattens in general
  def flattenGeneral(list: List[Any]): List[Any] = {
    list flatMap {
      case x: List[Any] => flattenGeneral(x)
      case item => List(item)
    }
  }

  def main(args: Array[String]): Unit = {
    println(flattenBuiltIn(List(List(1, 2, 3), List(4, 5, 6))))
    println(flatten(List(List(1, 2, 3), List(4, 5, 6))))
    println(flattenGeneral(List(List(1, 2, 3), List(4, 5, 6))))

    println(flattenBuiltIn(List(List(List(1, 10), 2, 3), List(4, 5, 6))))
    println(flatten(List(List(List(1, 10), 2, 3), List(4, 5, 6))))
    println(flattenGeneral(List(List(List(1, 10), 2, 3), List(4, 5, 6))))

    println(flattenGeneral(List(List(List(1, List(10)), 2, 3), 11, List(4, 5, 6))))

  }
}

