package careercup.orchard

object ValidParens {

  def validate(s: String, open: Char, close: Char): Boolean = {
    var isOpen = false
    for (i <- 0 to s.length - 1) {
      if (s.charAt(i) == open) {
        isOpen = true
      } else if (s.charAt(i) == close) {
        if (isOpen)
          return true
        else return false
      }
    }
    false
  }

  def main(args: Array[String]) {
    println(validate("{foo}", '{', '}'))
    println(validate("f{oo}", '{', '}'))
    println(validate("}foo{", '{', '}'))
    println(validate("{foo", '{', '}'))
    println(validate("foo{", '{', '}'))
    println(validate("f{oo", '{', '}'))
  }
}
