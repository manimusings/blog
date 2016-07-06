package lists


/*

P06 (*) Find out whether a list is a palindrome.
Example:
scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true

 */


object P06 {


  def isPalindromeBuiltIn[T](list: List[T]): Boolean = {
    val left = list.dropRight(list.length / 2)
    val right = list.reverse.dropRight(list.length / 2)
    left.equals(right)
  }

  def reverse[T](list: List[T]): (List[T], Int) = {
    def reverse[T](original: List[T], reversed: List[T], length: Int): (List[T], Int) = {
      original match {
        case Nil => (reversed, length)
        case x :: xs => reverse(xs, x +: reversed, length + 1)
        case _ => (original, length)
      }
    }
    reverse(list, List.empty[T], 0)
  }


  def isPalindrome[T](list: List[T]): Boolean = {
    def isPalindrome[T](original: List[T], reversed: List[T], length: Int, currentIndex: Int): Boolean = {
      original match {
        case Nil => true
        case x :: xs if (currentIndex < length / 2) && (x == reversed.head) => isPalindrome(xs, reversed.tail, length, currentIndex + 1)
        case x :: xs if (currentIndex >= length / 2) => true
        case _ => false
      }
    }
    val reversed = reverse(list)
    isPalindrome(list, reversed._1, reversed._2, 0)
  }


  def main(args: Array[String]): Unit = {
    println(isPalindrome(null))
    println(isPalindrome(List(null)))
    println(isPalindrome(List()))
    println(isPalindrome(List(1)))
    println(isPalindrome(List(1, 2)))
    println(isPalindrome(List(1, 2, 1)))
    println(isPalindrome(List(1, 2, 3)))
    println(isPalindrome(List(1, 2, 2, 1)))
    println(isPalindrome(List(1, 2, 3, 2, 1)))
    println(isPalindrome(List(1, 7, 2, 3, 5, 8)))
  }
}

