package cracking.chap9

import scala.collection.mutable.ListBuffer

object StringPermutations {

  def insertAll(target: String, permutations: Seq[String]): Seq[String] = {
    if (permutations.isEmpty)
      Seq(target)
    else {
      var newPermutations = ListBuffer[String]()
      for (permutation <- permutations) {
        for (i <- 0 to permutation.length) {
          val (head, remaining) = permutation.splitAt(i)
          newPermutations += (head + target + remaining)
        }
      }
      newPermutations
    }
  }

  def permute(str: String): Seq[String] = {
    def permute(str: String, permutations: Seq[String]): Seq[String] = {
      if (str.isEmpty)
        permutations
      else {
        val (head, remaining) = str.splitAt(1)
        val newPermutations = insertAll(head, permutations)
        permute(remaining, newPermutations)
      }
    }
    permute(str, Nil)
  }

  def main(args: Array[String]) {
    val str = "abcdefghijk"
    val permutations = permute(str)
    printf("%s=%s\n", str, permute(str))
    printf("expected length=%d, actual length=%d\n", str.toList.permutations.length, permutations.length)

  }
}
