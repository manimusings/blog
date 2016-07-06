
package object logic {

  object RichBoolean {

    def not(operand: Boolean): Boolean =
      if (operand) false else true

    def equ(operand1: Boolean, operand2: => Boolean): Boolean =
      operand1 == operand2

    def impl(operand1: Boolean, operand2: => Boolean): Boolean =
      if (operand1) operand2 else true

    //short circuit: only evaluate operand2 when called
    def and(operand1: Boolean, operand2: => Boolean): Boolean =
      if (operand1) operand2 else false

    //short circuit: only evaluate operand2 when called
    def or(operand1: Boolean, operand2: => Boolean): Boolean =
      if (operand1) operand1 else operand2


    def nand(operand1: Boolean, operand2: => Boolean) =
      not(and(operand1, operand2))

    def nor(operand1: Boolean, operand2: => Boolean) =
      not(or(operand1, operand2))

    def xor(operand1: Boolean, operand2: => Boolean): Boolean =
      or(
        and(operand1, operand2),
        and(not(operand1), not(operand2))
      )
  }


  implicit class RichBoolean(val self: Boolean) extends AnyVal {

    def not: Boolean = RichBoolean.not(self)

    def equ(operand: => Boolean): Boolean = RichBoolean.equ(self, operand)

    def impl(operand: => Boolean): Boolean = RichBoolean.impl(self, operand)

    //short circuit: only evaluate operand2 when called
    def and(operand: => Boolean): Boolean = RichBoolean.and(self, operand)

    //short circuit: only evaluate operand2 when called
    def or(operand: => Boolean): Boolean = RichBoolean.or(self, operand)


    def nand(operand: => Boolean): Boolean = RichBoolean.nand(self, operand)

    def nor(operand: => Boolean): Boolean = RichBoolean.nor(self, operand)

    def xor(operand: => Boolean): Boolean = RichBoolean.xor(self, operand)

  }

}
