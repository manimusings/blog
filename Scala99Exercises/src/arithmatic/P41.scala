package arithmatic

/*

P41 (**) A list of Goldbach compositions.
Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
scala> printGoldbachList(9 to 20)
10 = 3 + 7
12 = 5 + 7
14 = 3 + 11
16 = 3 + 13
18 = 5 + 13
20 = 3 + 17
In most cases, if an even number is written as the sum of two prime numbers, one of them is very small. Very rarely, the primes are both bigger than, say, 50. Try to find out how many such cases there are in the range 2..3000.

Example (minimum value of 50 for the primes):

scala> printGoldbachListLimited(1 to 2000, 50)
992 = 73 + 919
1382 = 61 + 1321
1856 = 67 + 1789
1928 = 61 + 1867
The file containing the full class for this section is arithmetic.scala.


 */


object P41 {


  def main(args: Array[String]): Unit = {
    println
    val inputs = List((1, 1000) /*, (2, 10000)*/)
    //Highest if both numbers are greater than this limit
    val limit = 50
    inputs.foreach { case (from, to) =>
      println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
      printf("sumOfPrimesInRange(%s-%s): \n", from, to)
      from.sumOfTwoPrimesTo(to).foreach {
        case (num, sumOfTwoPrimes) =>
          printf("  sumOfPrimes(%s): \n", num)
          //smallest difference, can use max but as this list is ordered if you think about it
          // the last one is always the one with smallest diff
          val smallestDiff = if (sumOfTwoPrimes.nonEmpty) sumOfTwoPrimes.last else ()
          sumOfTwoPrimes.foreach {
            //Highlight if this is the combination with the smallest difference
            case x if (x == smallestDiff) => printf("  ++++ %s + %s = %s \n", x._1, x._2, num)
            case (prime1, prime2) if (prime1 > limit && prime2 > 50) => printf("  **** %s + %s = %s \n", prime1, prime2, num)
            case (prime1, prime2) => printf("  %s + %s = %s \n", prime1, prime2, num)
          }
          println
      }
      println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    }

  }


}

