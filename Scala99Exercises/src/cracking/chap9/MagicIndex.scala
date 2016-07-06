package cracking.chap9

object MagicIndex {
  def magicIndex(values: Array[Int]): Seq[Int] = {
    if (values.isEmpty)
      Nil
    else {
      for {
        i <- 0 to values.length - 1
        if (values(i) == i)
      } yield i
    }

  }

  def main(args: Array[String]) {
    val values = Array(0, 1, 2, 7, 4, 5, 8)
    println(magicIndex(values))
  }
}
