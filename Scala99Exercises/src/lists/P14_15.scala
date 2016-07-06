package lists

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/*

P14 (*) Duplicate the elements of a list.
Example:
scala> duplicate(List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

P15 (**) Duplicate the elements of a list a given number of times.
Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

 */


object P14_15 {


  def duplicate[T](list: List[T], count: Int = 1): List[T] = {
    list match {
      case x :: xs => List.fill(count + 1)(x) ++ duplicate(xs, count)
      case x => x
    }
  }

  //  AMI: This is  tail recursive but looks not so concise
  def duplicateTR[T](list: List[T], count: Int = 1): List[T] = {
    @tailrec
    def duplicate[T](list: List[T], count: Int = 1, result: ListBuffer[T]): List[T] = {
      list match {
        case x :: xs => duplicate(xs, count, result ++ List.fill(count + 1)(x))
        case Nil => result.toList
        case _ => list
      }
    }
    duplicate(list, count, ListBuffer.empty)
  }

  def main(args: Array[String]): Unit = {
    println(duplicate(List('a, 'b, 'c, 'c, 'd)))
    println(duplicate(List('a, 'b, 'c, 'c, 'd), 2))
    println(duplicate(List('a, 'b, 'c, 'c, 'd), 0))
    println(duplicate(List('a, 'b, 'c, 'c, 'd), -1))
    println(duplicate(Nil))
    println(duplicate(null))
  }
}

