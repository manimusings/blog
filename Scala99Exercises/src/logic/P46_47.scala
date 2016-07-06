package logic

/*

P46 (**) Truth tables for logical expressions.
Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return true or false
according to the result of their respective operations; e.g. and(A, B) is true if and only if both A and B are true.
scala> and(true, true)
res0: Boolean = true

scala> xor(true. true)
res1: Boolean = false
A logical expression in two variables can then be written as an function of two variables,
e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))

Now, write a function called table2 which prints the truth table of a given logical expression in two variables.

scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
A     B     result
true  true  true
true  false true
false true  false
false false false

P47 (*) Truth tables for logical expressions (2).
Continue problem P46 by redefining and, or, etc as operators. (i.e. make them methods of a
new class with an implicit conversion from Boolean.) not will have to be left as a object method.
scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
A     B     result
true  true  true
true  false true
false true  false
false false false

 */


object P46_47 {

  import RichBoolean._

  def twoOperandInputs = List((false, false), (false, true), (true, false), (true, true))

  def truthTable(desc: String, func: (Boolean, => Boolean) => Boolean) = {
    printf("\n[%s]%-20s\n", desc, "=".padTo(50, '='))
    printf("%-20s%-20s%s\n", "A", "B", "result")
    twoOperandInputs.foreach { case (a, b) =>
      printf("%-20s%-20s%s\n", a, b, func(a, b))
    }
    printf("%-20s[%s]\n", "=".padTo(50, '='), desc)

  }


  def main(args: Array[String]): Unit = {
    truthTable("EQU", equ)
    truthTable("IMPL", impl)
    truthTable("AND", and)
    truthTable("OR", or)
    truthTable("NOR", nor)
    truthTable("NAND", nand)
    truthTable("XOR", xor)
    truthTable("a or (a and b)", (a, b) => a or (a and b))
    truthTable("a and (a or b)", (a, b) => a and (a or b))
    truthTable("a nand (a xor b)", (a, b) => a nand (a xor b))
    truthTable("a xor (a nand b)", (a, b) => a xor (a nand b))
    truthTable("(a xor b) nand (a or b)", (a, b) => (a xor b) nand (a or b))
  }
}

