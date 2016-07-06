package lists

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.util.Random

/*

P25 (*) Generate a random permutation of the elements of a list.
Hint: Use the solution of problem P23.
Example:

scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)


 */


object P25 {

  def swap[T](arr: ArrayBuffer[T], index1: Int, index2: Int): ArrayBuffer[T] = {
    if (index1 != index2) {
      val tmp = arr(index1)
      arr(index1) = arr(index2)
      arr(index2) = tmp
    }
    arr
  }

  def randomPermute[T](list: List[T]): List[T] = {

    @tailrec
    def randomPermute[T](currentIndex: Int, arr: ArrayBuffer[T]): ArrayBuffer[T] = {
      if (currentIndex >= 0 && currentIndex < arr.length)
        randomPermute(currentIndex + 1, swap(arr, currentIndex, Random.nextInt(arr.length)))
      else arr
    }
    randomPermute(0, new ArrayBuffer[T] ++ list).toList
  }


  def randomPermuteBuiltIn[T](list: List[T]): List[T] = {
    Random.shuffle(list)
  }

  def main(args: Array[String]): Unit = {

    println(randomPermute(List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomPermuteBuiltIn(List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

    println(randomPermute(List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomPermuteBuiltIn(List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

    println(randomPermute(List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomPermuteBuiltIn(List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

    println(randomPermute(Nil))
    println(randomPermuteBuiltIn(Nil))

    println(randomPermute(Nil))
    println(randomPermuteBuiltIn(Nil))

    //        println(randomSelect(5, null))
    //        println(randomSelectShuffle(5, null))


  }
}

