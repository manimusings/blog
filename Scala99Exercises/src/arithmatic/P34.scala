package arithmatic

/*

P34 (**) Calculate Euler's totient function phi(m).
Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
scala> 10.totient
res0: Int = 4

 */


object P34 {

  def main(args: Array[String]): Unit = {
    println
    printf("totient(%s): %s (%s) \n", 66, 66.totient.length, 66.totient.mkString(","))

  }
}

