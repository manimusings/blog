package careercup.bloomberg

import scala.Predef._

/*
Given an array A [0, 1, 2, 3, 4,9,5,7,6] and number N.
This means that the array consists of the numbers from 0 ... N. However, as you see, 8 is missing in A. Print the missing number.
Think about the case N = 10^6


 */

object FindMissingNumber {


  /**
    * This works even if more than one number is missing and finds the first one
    *
    * @param numbers
    * @param N
    * @return
    */
  def missing(numbers: Seq[Int], N: Int): Option[Int] = {
    //Have to sort as numbers may not be in order
    val sorted = numbers.sorted
    for (i <- 0 to N) {
      if (!sorted.isDefinedAt(i) || sorted(i) != i)
        return Some(i)
    }
    None
  }

  /*
  Find all missing
   */
  def missingAll(numbers: Seq[Int], N: Int): Seq[Int] = {
    //Have to sort as numbers may not be in order
    val sorted = numbers.sorted
    var missing = Vector[Int]()
    var idx = 0
    for (i <- 0 to N - 1) {
      sorted.isDefinedAt(idx) match {
        case false =>
          missing :+= i
          idx += 1
        case _ if (sorted(idx) != i) =>
          missing :+= i
        case _ =>
          idx += 1
      }
    }
    missing
  }

  /**
    * Only one number is missing
    *
    * @param numbers
    * @param N
    * @return
    */
  def missing1Formula(numbers: Seq[Int], N: Int): Option[Int] = {
    //+0 as this is zero indexed
    val expectedSum: Long = N * (N + 0) / 2
    val actualSum = numbers.sum
    val diff = (expectedSum - actualSum).asInstanceOf[Int]
    if (diff > 0)
      Some(diff)
    else None
  }

  def main(args: Array[String]): Unit = {
    println(missingAll(0 to (math.pow(10, 6).asInstanceOf[Int] - 3), math.pow(10, 6).asInstanceOf[Int]))
    println(missingAll(IndexedSeq(0, 2, 4, 5, 6, 7), 9))
  }

}

