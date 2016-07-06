package arithmatic

/*

P32 (**) Determine the greatest common divisor of two positive integer numbers.
Use Euclid's algorithm.
scala> gcd(36, 63)
res0: Int = 9

 */


object P32 {

  def main(args: Array[String]): Unit = {
    println
    printf("gcd(%s, %s): %s\n", 36, 24, 36.gcd(24))
    printf("gcd(%s, %s): %s\n", 654, 2322, 654.gcd(2322))

  }
}

