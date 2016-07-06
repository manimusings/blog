package effective.scala

import java.net.URL

import scala.io.Source
import scala.util.Try

object Names {

  trait Family

  trait Animal extends Family

  case object Lion extends Animal

  case object Cow extends Animal

  trait Bird extends Family

  trait Fliers

  case object Chicken extends Bird

  case object Ostrich extends Bird with Fliers

  def foo[T >: Fliers](animal: Seq[T]) = animal

  def main(args: Array[String]) {
    println(foo(List(Chicken)))
  }
}
