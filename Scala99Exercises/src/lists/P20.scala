package lists

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/*

P20 (*) Remove the Kth element from a list.
Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

 */


object P20 {


  //  def removeAt[T](n: Int, list: List[T]): List[T] = {
  //
  //    def removeAt[T](n: Int, list: List[T], index: Int): List[T] = {
  //      list match {
  //        case x :: xs if index < n => x :: removeAt(n, xs, index + 1)
  //        case x :: xs if index == n => xs
  //        case x => x
  //      }
  //    }
  //    removeAt(n, list, 0)
  //  }

  // AMI: This is using no builtins
  def removeAt[T](n: Int, list: List[T]): (List[T], T) = {
    @tailrec
    def removeAt[T](n: Int, list: List[T], left: ListBuffer[T], index: Int): (List[T], T) = {
      list match {
        case x :: xs if index < n => removeAt(n, xs, left :+ x, index + 1)
        case x :: xs if index >= n => ((left ++ xs).toList, x)
        case x => ((left ++ x).toList, null.asInstanceOf[T])
      }
    }
    removeAt(n, list, ListBuffer.empty, 0)
  }

  // AMI: This is using built APIs
  //  def removeAtBuiltIn[T](n: Int, list: List[T]): List[T] = {
  //    list.take(n) ++ list.drop(n+1)
  //  }

  // AMI: This is using built APIs
  def removeAtBuiltIn[T](n: Int, list: List[T]): (List[T], T) = {
    (list.take(n) ++ list.drop(n + 1), list(n))
  }

  def main(args: Array[String]): Unit = {

    println(removeAt(1, List('a, 'b, 'c, 'd)))
    println(removeAtBuiltIn(1, List('a, 'b, 'c, 'd)))

    println(removeAt(3, List('a, 'b, 'c, 'd)))
    println(removeAtBuiltIn(3, List('a, 'b, 'c, 'd)))


    println(removeAt(4, List('a, 'b, 'c, 'd)))
    //    println(removeAtBuiltIn(4, List('a, 'b, 'c, 'd)))

    println(removeAt(0, Nil))
    //        println(removeAtBuiltIn(0, Nil))

    println(removeAt(5, Nil))
    //        println(removeAtBuiltIn(5, Nil))

    //        println(removeAt(7, null))
    //        println(removeAtBuiltIn(10, null))
  }
}

