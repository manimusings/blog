package lists

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/*

P19 (**) Rotate a list N places to the left.
Examples:
scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

 */


object P19 {

  // AMI: This is using no builtins
  def rotate[T](n: Int, list: List[T]): List[T] = {
    @tailrec
    def rotateLeft[T](n: Int, list: List[T], group: ListBuffer[T], index: Int): List[T] = {
      list match {
        case x :: xs if index < n => rotateLeft(n, xs, group :+ x, index + 1)
        case x => (x ++ group).toList
      }
    }
    def rotateRight[T](n: Int, list: List[T], group: ListBuffer[T],  index: Int): List[T] = {
      list match {
        case x :: xs => rotateRight(n, xs, group :+ x, index + 1)
        case x => (x ++ group).toList
      }
    }
    if (n > 0)
      rotateLeft(n, list, ListBuffer.empty, 0)
    else throw new NoSuchMethodException("TODO: Need to implement rotateRight" )

  }

  // AMI: This is using built APIs
  def rotateBuiltIn[T](n: Int, list: List[T]): List[T] = {
    list.drop(n) ++ list.take(n)
  }


  def main(args: Array[String]): Unit = {

    println(rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(rotateBuiltIn(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(rotateBuiltIn(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(rotate(0, Nil))
    println(rotateBuiltIn(0, Nil))

    println(rotate(5, Nil))
    println(rotateBuiltIn(5, Nil))

    println(rotate(7, null))
    //    println(sliceBuiltIn(10, 7, null))
  }
}

