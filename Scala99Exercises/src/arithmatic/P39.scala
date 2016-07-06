package arithmatic

/*

P39 (*) A list of prime numbers.
Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
scala> listPrimesinRange(7 to 31)
res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

 */


object P39 {


  def main(args: Array[String]): Unit = {
    println
    val inputs = List((7, 31), (77, 873), (67252, 725241431))
    inputs.foreach { case (from, to) =>
      printf("listPrimesinRange(%s,%s): ", from, to)
      7.primesTo(to).foreach(printf("%s ", _))
      println
    }
  }
}

