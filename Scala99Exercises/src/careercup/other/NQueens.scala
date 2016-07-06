package careercup.other

/*
N Queens problem

 */

object NQueens {

  def generateYPositions(N: Int, xOffset: Int): Seq[(Int, Int)] = {
    (0 to (N - 1)) map ((xOffset, _))
  }


  def isPossibleSolution(current: (Int, Int), previous: Seq[(Int, Int)]): Boolean = {
    previous.forall {
      //reject same y cordinates or x coordinates or slope = 1 (diagonal)
      case (x, y) =>
        current._1 != x && current._2 != y &&
          math.abs((current._2 - y) * 1.0 / (current._1 - x)) != 1
    }
  }

  def findNQueenPositions(N: Int): Seq[Seq[(Int, Int)]] = {
    def findNQueenPositions(N: Int, xOffset: Int, previousSolutions: Seq[Seq[(Int, Int)]] = Nil): Seq[Seq[(Int, Int)]] = {
      if (N <= 0 || xOffset >= N) {
        return previousSolutions
      }

      val currentSolutions = generateYPositions(N, xOffset)
      val nextSolutions = previousSolutions match {
        //if xOffset==0 then this is the first time and copy currentSolutions
        case Nil if (xOffset == 0) => currentSolutions.map {
          List(_)
        }
        case Nil => Nil
        case previousSols => for {
          current <- currentSolutions
          previous <- previousSols
          if (isPossibleSolution(current, previous))
        } yield (previous :+ current)
      }
      findNQueenPositions(N, xOffset + 1, nextSolutions)
    }
    findNQueenPositions(N, 0, List.empty)
  }


  def main(args: Array[String]) = {
    //    println(isPossibleSolution((0,1), List((1,0))))
    //    println(generateYPositions(2, 1))
    println(findNQueenPositions(13).size)
    //
    //    val gen57 = (5, 7)
    //    val prev = List((0, 4), (1, 2), (2, 0), (3, 3), (4, 1))
    //    println(isPossibleSolution(gen57, prev))
  }
}

