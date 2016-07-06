package arithmatic

/*

P35 (**) Determine the prime factors of a given positive integer.
Construct a flat list containing the prime factors in ascending order.
scala> 315.primeFactors
res0: List[Int] = List(3, 3, 5, 7)

 */


object P35 {

  def main(args: Array[String]): Unit = {
    println
    printf("primeFactors(%s): %s \n", 315, 315.primeFactors.mkString(", "))
    printf("primeFactors(%s): %s \n", 1548586373, 1548586373.primeFactors.mkString(", "))
  }
}

