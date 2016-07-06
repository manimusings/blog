package lists

/*

P16 (**) Drop every Nth element from a list.
Example:
scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

 */


object P16 {


  // AMI: No builtin APIs
  def drop[T](nth: Int, list: List[T]): List[T] = {
    def drop[T](nth: Int, list: List[T], runningCount: Int): List[T] = {
      list match {
        case x :: xs if runningCount < nth => x :: drop(nth, xs, runningCount + 1)
        case x :: xs if runningCount == nth => drop(nth, xs, 1)
        case x => x
      }
    }
    drop(nth, list, 1)
  }

  // AMI: This is using some built APIs
  def dropBuiltIn[T](n: Int, list: List[T]): List[T] = {
    list match {
      case x :: xs if n > 0 => list.take(n - 1) ++ drop(n, list.drop(n))
      case x => x
    }
  }

  def main(args: Array[String]): Unit = {
    //drop every 3rd
    println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(dropBuiltIn(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //drop every other
    println(drop(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(dropBuiltIn(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    //drop every item
    println(drop(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(dropBuiltIn(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(drop(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(dropBuiltIn(0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))

    println(drop(0, Nil))
    println(dropBuiltIn(0, Nil))
    println(drop(5, Nil))
    println(dropBuiltIn(5, Nil))
    println(drop(10, null))
    println(dropBuiltIn(10, null))
  }
}

