package com.musings.mani

import scala.annotation.tailrec
import scala.collection.mutable

object FactorialTailRecursive {

  def factorial(n: Int): Long = {
    @tailrec
    def factorial(n: Int, result: Long): Long = {
      if (n < 2) result
      else factorial(n - 1, n * result)
    }
    factorial(n, 1)
  }

  def main(args: Array[String]): Unit = {
    val inputs = 1 to 15
    inputs.foreach { case input =>
      printf("\nfactorial of %d = %d", input, factorial(input))
    }
  }
}