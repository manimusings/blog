package com.musings.mani

import scala.annotation.tailrec
import scala.collection.mutable

object FactorialMemoTailRecursive {

  private val factorials = mutable.HashMap[Int, Long](1 -> 1, 2 -> 2)

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

  def main(args: Array[String]): Unit = {
    val inputs = 1 to 15
    inputs.foreach { case input =>
      printf("\nfactorial of %d = %d", input, factorial(input))
    }
  }
}