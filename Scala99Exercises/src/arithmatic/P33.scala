package arithmatic

/*

P33 (*) Determine whether two positive integer numbers are coprime.
Two numbers are coprime if their greatest common divisor equals 1.
scala> 35.isCoprimeTo(64)
res0: Boolean = true

 */


object P33 {

  def main(args: Array[String]): Unit = {
    println
    printf("isCoprime(%s, %s): %s\n", 35, 64, 35.isCoprime(64)==64.isCoprime(35))

  }
}

