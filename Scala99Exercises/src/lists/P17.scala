package lists

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/*

P17 (*) Split a list into two parts.
The length of the first part is given. Use a Tuple for your result.
Example:

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

 */


object P17 {


  // AMI: This is using no builtins
  def split[T](n: Int, list: List[T]): (List[T], List[T]) = {
    @tailrec
    def split[T](n: Int, list: List[T], group: ListBuffer[T], index: Int): (List[T], List[T]) = {
      list match {
        case x :: xs if index < n => split(n, xs, group :+ x, index + 1)
        case x :: xs => (group.toList, xs)
        case x => (list, list)
      }
    }
    split(n, list, ListBuffer.empty, 0)
  }

  // AMI: This is using some built APIs
  def splitBuiltIn[T](n: Int, list: List[T]): (List[T], List[T]) = {
    list.splitAt(n)
  }

  // AMI: BuiltIns: This works as well
  def splitBuiltIn2[T](n: Int, list: List[T]): (List[T], List[T]) = {
    (list.take(n), list.drop(n))
  }

  def main(args: Array[String]): Unit = {

    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn2(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(split(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn2(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(split(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn2(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(split(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn2(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitBuiltIn(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(split(0, Nil))
    println(splitBuiltIn2(0, Nil))
    println(splitBuiltIn(0, Nil))

    println(split(5, Nil))
    println(splitBuiltIn2(5, Nil))
    println(splitBuiltIn(5, Nil))

    println(split(10, null))
//    println(splitBuiltIn2(10, null))
//    println(splitBuiltIn(10, null))
  }
}

