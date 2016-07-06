package cracking.chap9

object NCents {


  def main(args: Array[String]) {
    val n = 30
    val permutations =
      for {
        d01 <- 0 to n
        d05 <- 0 to n / 5
        d10 <- 0 to n / 10
        d25 <- 0 to n / 4
        if (n == d25 * 25 + d10 * 10 + d05 * 5 + d01)
      } yield ((d25, d10, d05, d01))

    println(permutations)
  }
}
