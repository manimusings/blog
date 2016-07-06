import scala.collection.mutable

package object arithmatic {

  object RichInt {
    //CACHING: Maintain order
    val primeNumbersCache = mutable.LinkedHashMap(1 -> false, 2 -> true, 3 -> true)
    val sumOfPrimesCache = mutable.LinkedHashSet.empty[(Int, Int)]

    def isPrime(num: Int): Boolean = {
      primeNumbersCache.get(num) match {
        case Some(isPrime) => isPrime
        case _ =>
          val isPrimeNum = num % 2 != 0 && 2.to(Math.sqrt(num).toInt).filter(isPrime).forall(num % _ != 0)
          primeNumbersCache += (num -> isPrimeNum)
          isPrimeNum
      }
    }

    def euclidGcd(num1: Int, num2: Int): Int = {
      if (num2 == 0) num1
      else euclidGcd(num2, num1 % num2)
    }

    def isCoprime(num1: Int, num2: Int): Boolean = {
      euclidGcd(num1, num2) == 1
    }

    def primeFactors(num: Int): Stream[Int] = {
      def getPrimeFactors(num: Int, factor: Int): Stream[Int] = {
        if (num < 2)
          Stream.empty
        else if (num % factor == 0)
          factor #:: getPrimeFactors(num / factor, factor)
        else getPrimeFactors(num, factor + 1)
      }
      getPrimeFactors(num, 2)
    }

    def primesInRange(from: Int, to: Int): Stream[Int] = {
      from.to(to).toStream.filter(_.isPrime)
    }

    //Goldbach's conjecture
    def sumOfTwoPrimes(num: Int): List[(Int, Int)] = {
      if (num > 2 && num % 2 == 0) {
        val targetPrimes = primesInRange(2, num - 2)
        //Maintain order
        val sumOfPrimesLocal = mutable.LinkedHashSet.empty[(Int, Int)]
        for {
          targetPrimeLHS <- targetPrimes
          //only take lhs or larger to avoid double counting i.e 3+5=8 and 5+3=8
          //"=" for numbers like 4=2+2, 6 = 3+3 etc
          targetPrimeRHS <- targetPrimes.filter(_ >= targetPrimeLHS)
          if (targetPrimeLHS + targetPrimeRHS == num)
        } {
          if (sumOfPrimesCache.contains(targetPrimeLHS, targetPrimeRHS)) {
            sumOfPrimesLocal += ((targetPrimeLHS, targetPrimeRHS))
          } else {
            sumOfPrimesCache += ((targetPrimeLHS, targetPrimeRHS))
            sumOfPrimesLocal += ((targetPrimeLHS, targetPrimeRHS))
          }
        }
        sumOfPrimesLocal.toList
      }
      else Nil
    }

    def sumOfTwoPrimesInRange(from: Int, to: Int): Stream[(Int, List[(Int, Int)])] = {
      from.to(to).toStream.filter(_ % 2 == 0).map(num => (num, sumOfTwoPrimes(num)))
    }
  }


  implicit class RichInt(val self: Int) extends AnyVal {

    import RichInt._

    def isPrime: Boolean = RichInt.isPrime(self)

    def gcd(num: Int): Int = euclidGcd(self, num)

    def isCoprime(num: Int): Boolean = RichInt.isCoprime(self, num)

    def totient: Stream[Int] = {
      1.to(self).toStream.filter(_.isCoprime(self))
    }

    def primeFactors: Stream[Int] = RichInt.primeFactors(self)

    def primesFrom(from: Int): Stream[Int] = primesInRange(from, self)

    def primesTo(to: Int): Stream[Int] = primesInRange(self, to)

    def sumOfTwoPrimes: List[(Int, Int)] = RichInt.sumOfTwoPrimes(self)

    def sumOfTwoPrimesFrom(from: Int): Stream[(Int, List[(Int, Int)])] = sumOfTwoPrimesInRange(from, self)

    def sumOfTwoPrimesTo(to: Int): Stream[(Int, List[(Int, Int)])] = sumOfTwoPrimesInRange(self, to)
  }

}
