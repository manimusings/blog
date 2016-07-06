package lists

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/*

P18 (**) Extract a slice from a list.
Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)

 */


object P18 {


  // AMI: This is using no builtins
  def slice[T](from: Int, to: Int, list: List[T]): List[T] = {
    @tailrec
    def slice[T](from: Int, to: Int, list: List[T], group: ListBuffer[T], index: Int): List[T] = {
      list match {
        case x :: xs if index < from => slice(from, to, xs, group, index + 1)
        case x :: xs if index >= from && index < to => slice(from, to, xs, group :+ x, index + 1)
        case x => group.toList
      }
    }
    slice(from, to, list, ListBuffer.empty, 0)
  }

  // AMI: This is using built APIs
  def sliceBuiltIn[T](from: Int, to: Int, list: List[T]): List[T] = {
    list.slice(from, to)
  }


  def main(args: Array[String]): Unit = {

    println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceBuiltIn(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(slice(7, 12, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceBuiltIn(7, 12, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(slice(-1, 2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceBuiltIn(-1, 2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(slice(-7, -12, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceBuiltIn(-7, -12, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(slice(0, 0, Nil))
    println(sliceBuiltIn(0, 0, Nil))

    println(slice(5, 6, Nil))
    println(sliceBuiltIn(5, 6, Nil))

    println(slice(10, 7, null))
    //    println(sliceBuiltIn(10, 7, null))
  }
}

