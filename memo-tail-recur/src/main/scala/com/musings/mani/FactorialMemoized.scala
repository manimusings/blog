package com.musings.mani

import scala.collection.mutable

object FactorialMemoized {

  private val factorials = mutable.HashMap[Int, Long](1 -> 1, 2 -> 2)

  def factorial(n: Int): Long = {
    factorials.getOrElseUpdate(n, n * factorial(n - 1))
  }

  def main(args: Array[String]): Unit = {
    val inputs = 1 to 15
    inputs.foreach { case input =>
      printf("\nfactorial of %d = %d", input, factorial(input))
    }
  }
}