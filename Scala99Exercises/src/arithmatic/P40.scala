package arithmatic

/*

P40 (**) Goldbach's conjecture.
Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. E.g. 28 = 5 + 23.
It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
Write a function to find the two prime numbers that sum up to a given even integer.
scala> 28.goldbach
res0: (Int, Int) = (5,23)


 */


object P40 {


  def main(args: Array[String]): Unit = {
    println
    val inputs = 2.to(100).filter(_ % 2 == 0)
    inputs.foreach { num =>
      printf("sumOfPrimes(%s): \n", num)
      num.sumOfTwoPrimes.foreach { case (prime1, prime2) =>
        printf("%s + %s = %s \n", prime1, prime2, num)
      }
      println
    }

  }


}

