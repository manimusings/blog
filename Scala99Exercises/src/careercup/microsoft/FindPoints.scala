package careercup.microsoft

/*
Given a few points in first quadrant – (x1, y1) …..(xn, yn) and given another set of points (a1, b1 …..an, bn),
 determine whether all the points (a1, b1 … an, bn) have already occured in (x1, y1) …..xn, yn)

 */

object FindPoints {

  //this solution is O(n^2)
  def containsAll[T](givenPoints: List[(T, T)], testPoints: List[(T, T)], quardrant: (T, T) => Boolean): Boolean = {
    testPoints.forall {
      case point@(x, y) => quardrant(x, y) && givenPoints.contains(point)
    }
  }

  def main(args: Array[String]): Unit = {
    //first quadrant
    println(containsAll(List((1, 4), (2, 5), (7, 10)), List((1, 4), (7, 10)), (x: Int, y: Int) => (x > 0 && y > 0)))
  }

}

