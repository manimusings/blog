package lists

/*

P21 (*) Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

 */


object P21 {


  def insertAt[T](n: Int, item: T, list: List[T]): List[T] = {

    def insertAt[T](n: Int, item: T, list: List[T], index: Int): List[T] = {
      list match {
        case x :: xs if index < n => x :: insertAt(n, item, xs, index + 1)
        case x => item :: x
      }
    }
    insertAt(n, item, list, 0)
  }

  //   AMI: This is using built APIs
  def insertAtBuiltIn[T](n: Int, item: T, list: List[T]): List[T] = {
    list.take(n) ++ (item :: list.drop(n))
  }


  def main(args: Array[String]): Unit = {

    println(insertAt(1, 'new, List('a, 'b, 'c, 'd)))
    println(insertAtBuiltIn(1, 'new, List('a, 'b, 'c, 'd)))

    println(insertAt(3, 'new, List('a, 'b, 'c, 'd)))
    println(insertAtBuiltIn(3, 'new, List('a, 'b, 'c, 'd)))


    println(insertAt(4, 'new, List('a, 'b, 'c, 'd)))
    println(insertAtBuiltIn(4, 'new, List('a, 'b, 'c, 'd)))

    println(insertAt(0, 'new, Nil))
    println(insertAtBuiltIn(0, 'new, Nil))

    println(insertAt(5, 'new, Nil))
    println(insertAtBuiltIn(5, 'new, Nil))

    //    println(insertAt(7, 'new, null))
    //    println(insertAtBuiltIn(7, 'new, null))
  }
}

