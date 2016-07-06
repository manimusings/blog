package lists

import java.util
import java.util.{Collections, Comparator}

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, ArrayBuffer}
import scala.util.Random

/*

P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities
(C(N,K) denotes the well-known binomial coefficient).
For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
Example:

scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

 */


object P26 {
  //  var factorials = new util.TreeMap[Int, Int](Collections.reverseOrder[Int])
  //factorials.put(1,1)
  //factorials.put(2,2)

  private val factorials = mutable.HashMap[Int, Long](1 -> 1, 2 -> 2)

  //  tail recursive memoized version of factorial
  def factorial(n: Int): Long = {
    @tailrec
    def factorial(n: Int, current: Int, result: Long): Long = {
      if (current < n)
        factorial(n, current + 1, factorials.getOrElseUpdate(current, current * result))
      else
        factorials.getOrElseUpdate(current, current * result)
    }

    factorial(n, 1, 1)
    // This can be further optimized by counting up from the max in the cache
    // Meaning if you want to compute f(9) and f(7) is already in the cache
    // Only calculate up from f(7)
    // factorial(n, Math.min(n, factorials.keys.max), 1)
  }

  //  //AMI: memoized version
  //  def factorial(n: Int): Long = {
  //    factorials.getOrElseUpdate(n, n * factorial(n - 1))
  //  }


  //  def factorial(n: Int): Long = {
  //    @tailrec
  //    def factorial(n: Int, result: Long): Long = {
  //      if (n < 2) result
  //      else factorial(n - 1, n * result)
  //    }
  //
  //    factorials.getOrElseUpdate(n, factorial(n, 1))
  //  }

  def embed[T](x: T, list: List[T]): List[List[T]] = {
    def embed[T](x: T, head: List[T], tail: List[T]): List[List[T]] = {
      tail match {
        case y :: ys => List((head :+ x) ++ (y :: ys)) ++ embed(x, head :+ y, ys)
        case Nil => List(head :+ x)
        case _ => List(List.empty[T])
      }
    }
    embed(x, List.empty[T], list)
  }

  //    def factorial(n: Int): Int = {
  //      if (n < 2) 1
  //      else n * factorial(n - 1)
  //    }


  //    //  AMI: tail recursive version of factorial
  //    def factorial(n: Int): Long = {
  //      @tailrec
  //      def factorial(n: Int, result: Long): Long = {
  //        if (n < 2) result
  //        else factorial(n - 1, n * result)
  //      }
  //      factorial(n, 1)
  //    }


  def NchooseR(n: Int, r: Int): Long = {
    factorial(n) / (factorial(r) * factorial(n - r))
  }

  //  def permutationFormula(n: Int, r: Int, anyOrder: Boolean = false): Int = {
  //    if (anyOrder) {
  //      factorial(n)
  //    } else {
  //      factorial(n) / factorial(n - r)
  //    }
  //  }

  // n P r, no repetitions and order does matter
  // meaning abc and acb are counted as 2 cases
  def permutations[T](stream: List[T]): List[List[T]] = {
    stream match {
      case x :: Nil => List(List(x))
      case x :: xs =>
        for {
          previous <- permutations(xs)
          permutation <- embed(x, xs)
        } yield (permutation)
      case _ => List(List.empty[T])
    }
  }

  // N choose r, no repetitions and order does not matter
  // meaning abc and acb are counted only once
  def combinations[T](n: Int, stream: List[T]): List[List[T]] = {
    stream match {
      case x :: xs if n > 1 =>
        (for {
          previous <- combinations(n - 1, xs)
        } yield (x :: previous)) ++ combinations(n, xs)
      case x :: xs if n == 1 => List(x) :: xs.map(List(_))
      case _ => Nil
    }
  }

  def main(args: Array[String]): Unit = {

    println(factorial(7))
    println(factorial(4))
    println(factorial(5))
    println(factorial(5))
    println(factorial(20))
  }

  def main1(args: Array[String]): Unit = {

    val permutationInputs = List(
      List.empty[Symbol],
      List('a),
      List('a, 'b),
      List('a, 'b, 'c),
      List('a, 'b, 'c, 'd)
    )

    println("*********************************** PERMUTATIONS ***********************************")
    permutationInputs.foreach {
      case input =>
        val p = permutations(input)
        printf("\n%s [%s;%s]", p, p.length, factorial(input.length))
    }
    println
    println("*********************************** PERMUTATIONS ***********************************")

    val combinationInputs = List(
      (1, List('a, 'b)),
      (2, List('a, 'b)),
      (2, List('a, 'b, 'c)),
      (3, List('a, 'b, 'c)),
      (0, List('a, 'b, 'c, 'd)),
      (1, List('a, 'b, 'c, 'd)),
      (2, List('a, 'b, 'c, 'd)),
      (3, List('a, 'b, 'c, 'd)),
      (4, List('a, 'b, 'c, 'd)),
      (5, List('a, 'b, 'c, 'd)),
      (3, List('a, 'b, 'c, 'd, 'e, 'f, 'g)),
      (5, List('a, 'b, 'c, 'd, 'e, 'f, 'g)),
      (2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)),
      // In how many ways can a committee of 3 be chosen from a group of 12 people?
      // We all know that there are C(12,3) = 220 possibilities
      (3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'l))
    )

    println
    println("*********************************** COMBINATIONS ***********************************")
    combinationInputs.foreach {
      case (r, input) =>
        val c = combinations(r, input)
        printf("\n%s [%s;%s]", c, c.length, NchooseR(input.length, r))
    }
    println
    println("*********************************** COMBINATIONS ***********************************")

  }
}

