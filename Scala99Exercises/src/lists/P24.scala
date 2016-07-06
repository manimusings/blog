package lists

import scala.util.Random

/*

P24 (*) Lotto: Draw N different random numbers from the set 1..M.
Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)

 */


object P24 {


  //AMI: Using shuffling: Shuffle and start returning from head until list is exhausted
  def randomSelectShuffle[T](n: Int, set: Set[T]): List[T] = {

    def randomSelectShuffle[T](n: Int, set: Set[T]): List[T] = {
      set.headOption match {
        case Some(x) if n > 0 => x :: randomSelectShuffle(n - 1, set.tail)
        case _ => Nil
      }
    }
    randomSelectShuffle(n, Random.shuffle(set))
  }

  def randomSelect(n: Int, size: Int): List[Int] = {
    randomSelectShuffle(n, 1.to(size).toSet)
  }

  def main(args: Array[String]): Unit = {

    println(randomSelect(3, 10))

    println(randomSelect(8, 9))

    println(randomSelect(12, 11))

    println(randomSelect(0, 10))

    println(randomSelect(-1, 10))

    println(randomSelect(5, 0))

    println(randomSelect(5, -1))

    println(randomSelect(5, -1))

  }
}

