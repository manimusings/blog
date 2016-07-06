package cracking.chapter2

import scala.collection.immutable.Queue

object PartitionListAroundValue_ex_2_4 {

  def partition(list: List[Int], x: Int): (Seq[Int], Seq[Int]) = {
    def partition(list: List[Int], x: Int, partitioned: (Seq[Int], Seq[Int])): (Seq[Int], Seq[Int]) = {
      list match {
        case Nil => partitioned
        case head :: tail if (head < x) => partition(tail, x, (partitioned._1 :+ head, partitioned._2))
        case head :: tail if (head >= x) => partition(tail, x, (partitioned._1, partitioned._2 :+ head))
      }
    }
    partition(list, x, (Queue(), Queue()))
  }

  def main(args: Array[String]) {
    //    lastKth(List(1,2,3,4,5),4)
    println(partition(List(1, 2, 3, 4, 5), 3))

  }
}

