package arithmatic

/*

P36 (**) Determine the prime factors of a given positive integer (2).
Construct a list containing the prime factors and their multiplicity.
scala> 315.primeFactorMultiplicity
res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
Alternately, use a Map for the result.

scala> 315.primeFactorMultiplicity
res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

P37 (**) Calculate Euler's totient function phi(m) (improved).
See problem P34 for the definition of Euler's totient function.
If the list of the prime factors of a number m is known in the form of problem P36 then the function phi(m>)
can be efficiently calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors
(and their multiplicities) of a given number m. Then phi(m) can be calculated with the following formula:
phi(m) = (p1-1)*p1(m1-1) * (p2-1)*p2(m2-1) * (p3-1)*p3(m3-1) * ...

Note that ab stands for the bth power of a.

P38 (*) Compare the two methods of calculating Euler's totient function.
Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example.

 */


object P36_37_38 {


  //AMI: Copy from P10
  def encode[T](elements: Stream[T])(implicit group: Option[(T, Int)] = None): Stream[(T, Int)] = {
    elements match {
      case x #:: xs if group.nonEmpty && group.get._1 == x => encode(xs)(Some((group.get._1, group.get._2 + 1)))
      case x #:: xs if group.nonEmpty => group.get #:: encode(xs)(Some((x, 1)))
      case x #:: xs => encode(xs)(Some((x, 1)))
      case _ if group.nonEmpty => Stream(group.get)
      case _ => Stream.empty
    }
  }

  def primeFactorMultiplicity(num: Int): Stream[(Int, Int)] = {
    encode(num.primeFactors)
  }

  def totient(num: Int): Int = {
    def totient(primeFactors: Stream[(Int, Int)]): Int = {
      primeFactors match {
        case x #:: xs => (x._1 - 1) * Math.pow(x._1, x._2 - 1).toInt * totient(xs)
        case _ => 1
      }
    }
    //AMI: Tail recursive version
    //    @tailrec
    //    def totient(primeFactors: List[(Int, Int)], result: Double): Int = {
    //      primeFactors match {
    //        case x :: xs =>  totient(xs, (x._1 - 1) * Math.pow(x._1, x._2 - 1).toInt *result)
    //        case _ => result
    //      }
    //    }
    totient(primeFactorMultiplicity(num))
  }

  def main(args: Array[String]): Unit = {
    println
    val inputs = List(66, 315, 1548586373)
    inputs.foreach { input =>
      //AMI:previous totient is very very slow for large nums, the current totient is much faster
      if (input < Math.pow(10, 6))
        printf("primeFactorMultiplicity(%s): %s totient(improved:%s, previous:%s) \n", input, primeFactorMultiplicity(input).toList, totient(input), input.totient.length)
      else
        printf("primeFactorMultiplicity(%s): %s totient(improved:%s) \n", input, primeFactorMultiplicity(input).toList, totient(input))

    }
  }


}

