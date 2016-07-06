package arithmatic

import scala.util.Random

/*

P31 (**) Determine whether a given integer number is prime.
scala> 7.isPrime
res0: Boolean = true

 */


object P31 {

  def main(args: Array[String]): Unit = {
    val from = 1
    val to = 10000
    printf("Primes from %s to %s:\n", from, to)
    val primes = from.to(to).toStream.filter(_.isPrime)
    var sum: Long = 0
    primes.foreach { num =>
      printf("%s ", num)
      sum += num
    }
    printf("\nSum: %s\n", sum)
    printf("Is %s prime? %s\n", 15485863, 15485863.isPrime)
  }
}

