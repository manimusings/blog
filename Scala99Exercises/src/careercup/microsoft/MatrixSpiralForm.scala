package careercup.microsoft

import scala.collection.mutable.ArrayBuffer

/*

Given a 2D array, print it in spiral form. See the following examples.

Input:
1    2   3   4
5    6   7   8
9   10  11  12
13  14  15  16
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


Input:
1   2   3   4  5   6
7   8   9  10  11  12
13  14  15 16  17  18
Output:
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

*/
object MatrixSpiralForm {

  def toSpiralForm[T](n: Int, m: Int, matrix: Array[Array[T]]): Seq[T] = {
    def toSpiralForm[T](n: Int, m: Int, start: (Int, Int), matrix: Array[Array[T]], prevSpiral: Seq[T]): Seq[T] = {
      if (n < 0 || m < 0)
        return prevSpiral
      var currentSpiral = prevSpiral
      //move right row
      for (col <- start._2 to m) {
        currentSpiral = currentSpiral :+ matrix(start._1)(col)
      }
      //move dowm col
      for (row <- start._1 + 1 to n) {
        currentSpiral = currentSpiral :+ matrix(row)(m)
      }
      //move left col
//      for (col <- m to start._2) {
//        currentSpiral = currentSpiral :+ matrix(row)(m)
//      }
      println(currentSpiral)
      toSpiralForm(n - 2, m - 2, (start._1 + 1, m - 2 - 1), matrix, currentSpiral)
    }
    toSpiralForm(n - 1, m - 1, (0, 0), matrix, ArrayBuffer())
  }

  def main(args: Array[String]) {
    val n = 4
    val m = 4
    val matrix = Array.ofDim[String](n, m)
    var count = 0
    for {
      i <- 0 to n - 1
      j <- 0 to m - 1
    } {
      count += 1
      matrix(i)(j) = count.toString()
    }
    println(matrix.map(_.mkString(" ")).mkString("\n"))
    toSpiralForm(n, m, matrix)
  }
}
