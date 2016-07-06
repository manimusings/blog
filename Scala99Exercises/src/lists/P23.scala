package lists

import scala.util.Random

/*

P23 (**) Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
Hint: Use the solution to problem P20

 */


object P23 {

  //AMI: uncorrelated random, does NOT care if the element was returned before.
  //Good if the n <=length of the list
  def randomSelectTrue[T](n: Int, list: List[T]): List[T] = {
    def randomSelect[T](n: Int, seq: IndexedSeq[T]): List[T] = {
      if (n > 0 && seq.length > 0) seq(Random.nextInt(seq.length)) :: randomSelect(n - 1, seq)
      else Nil
    }
    //convert to  an IndexedSeq as it provides fast random-access of elements
    randomSelect(n, list.toIndexedSeq)
  }

  //AMI: correlated random, DOES NOT return already returned elements.
  //Good if the n << length of the list
  def randomSelect[T](n: Int, list: List[T]): List[T] = {

    def removeAt[T](n: Int, seq: IndexedSeq[T]): IndexedSeq[T] = {
      seq.take(n) ++ seq.drop(n + 1)
    }

    def randomSelect[T](n: Int, seq: IndexedSeq[T]): List[T] = {
      if (n > 0 && seq.length > 0) {
        val index = Random.nextInt(seq.length)
        seq(index) :: randomSelect(n - 1, removeAt(index, seq))
      }
      else Nil
    }
    //convert to  an IndexedSeq as it provides fast random-access of elements
    randomSelect(n, list.toIndexedSeq)
  }

  //AMI: Using shuffling: Shuffle and start returning from head until list is exhausted
  def randomSelectShuffle[T](n: Int, list: List[T]): List[T] = {

    def randomSelectShuffle[T](n: Int, list: List[T]): List[T] = {
      list match {
        case x :: xs if n > 0 => x :: randomSelectShuffle(n - 1, xs)
        case x => x
      }
    }
    randomSelectShuffle(n, Random.shuffle(list))
  }

  def main(args: Array[String]): Unit = {

    println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelectTrue(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelectShuffle(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

    println(randomSelect(8, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelectTrue(8, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelectShuffle(8, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

    println(randomSelect(11, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelectTrue(11, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    println(randomSelectShuffle(11, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))

    println(randomSelect(0, Nil))
    println(randomSelectTrue(0, Nil))
    println(randomSelectShuffle(0, Nil))

    println(randomSelect(5, Nil))
    println(randomSelectTrue(5, Nil))
    println(randomSelectShuffle(5, Nil))

//        println(randomSelect(5, null))
//        println(randomSelectTrue(5, null))
//        println(randomSelectShuffle(5, null))


  }
}

