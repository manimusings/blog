package lists



/*

P22 (*) Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)

 */


object P22 {


  def range(from: Int, to: Int): List[Int] = {
    if (to > from)
      from :: range(from + 1, to)
    else Nil
  }

  //   AMI: This is using built APIs
  def rangeBuiltIn[T](from: Int, to: Int): List[Int] = {
    from.until(to).toList
  }


  def main(args: Array[String]): Unit = {

    println(range(0, 10))
    println(rangeBuiltIn(0, 10))

    println(range(3, 8))
    println(rangeBuiltIn(3, 8))

    println(range(-13, -4))
    println(rangeBuiltIn(-13, -4))

    println(range(5, 2))
    println(rangeBuiltIn(5, 2))
  }
}

