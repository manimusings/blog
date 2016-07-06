package cracking.chap9

object NSteps {

  //non iterative, brute force O(n^3)
  def possibleWaysToClimbSteps(n: Int): Seq[(Int, Int, Int)] = {
    for {
      d3 <- n / 3 to 0 by -1
      d2 <- n / 2 to 0 by -1
      d1 <- n to 0 by -1
      if (n == d3 * 3 + d2 * 2 + d1)
    } yield ((d3, d2, d1))
  }

  def countWays(n: Int): Int = {
    if (n < 0) {
      0;
    } else if (n == 0) {
      1;
    } else {
      countWays(n - 1) + countWays(n - 2) +
        countWays(n - 3);
    }
  }

  def main(args: Array[String]) {
    val n = 3
    println(possibleWaysToClimbSteps(n))
    println(countWays(n))
  }
}
