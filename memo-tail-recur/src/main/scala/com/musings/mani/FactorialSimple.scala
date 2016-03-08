package com.musings.mani

object FactorialSimple {

  def factorial(n: Int): Long = {
    if (n < 2) 1
    else n * factorial(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val inputs = 1 to 15
    inputs.foreach { case input =>
      printf("\nfactorial of %d = %d", input, factorial(input))
    }
  }
}
