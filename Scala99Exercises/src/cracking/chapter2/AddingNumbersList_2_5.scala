package cracking.chapter2

object AddingNumbersList_2_5 {
  //Part1
  def add(list1: List[Int], list2: List[Int]) = {
    def add(list1: List[Int], list2: List[Int], result: Int, position: Int): Int = {
      if (list1.isEmpty && list2.isEmpty)
        return result
      val left = list1.headOption.getOrElse(0)
      val right = list2.headOption.getOrElse(0)
      add(list1.tail, list2.tail, ((left + right) * math.pow(10, position).asInstanceOf[Int]) + result, position + 1)
    }
    add(list1, list2, 0, 0)
  }

  def addList(list1: List[Int], list2: List[Int]): Seq[Int] = {
    def addList(list1: List[Int], list2: List[Int], result: Seq[Int], carry: Int): Seq[Int] = {
      if (list1.isEmpty && list2.isEmpty)
        if (carry > 0)
          return result :+ carry
      else return result
      val left = list1.headOption.getOrElse(0)
      val right = list2.headOption.getOrElse(0)
      addList(list1.tail, list2.tail, result :+ (left + right + carry) % 10, (left + right + carry) / 10)
    }
    addList(list1, list2, Nil, 0)
  }

  def main(args: Array[String]) {
    //    lastKth(List(1,2,3,4,5),4)
    println(addList(List(3, 4, 1), List(8, 7, 9)))
    println(List(3, 2, 1).headOption)

  }
}

