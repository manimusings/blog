
package object codes {

  object RichInt {

    def grayCodes(bits: Int): Stream[String] = {
      if (bits > 0) {
        val prev = grayCodes(bits - 1)
        prev.map("0" + _) ++ prev.map("1" + _)
      } else {
        Stream("")
      }
    }
  }


  implicit class RichInt(val self: Int) extends AnyVal {
    def grayCodes: Stream[String] = RichInt.grayCodes(self)
  }

}
