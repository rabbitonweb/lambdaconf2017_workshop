package pfp.intro

import scalaz._, Scalaz._

object Functions {

  /** Defining a function */

  val func: String => Int = (s: String) => s.length
  val func_alt: String => Int = ???

  val func2: (Int, Int) => Int = ???
  val func2_alt: (Int, Int) => Int = ??? 

  /** Using functions */
  val list = List("hello", "world", "!")
  list.map(func)
  list.map(func_alt)
  list.map(_.length)
  
  /** Function composition */

  // f(x) = x + 1
  val f = (x: Int) => x + 1
  // g(x) = "x"
  val g = (x: Int) => x.toString

  // h(x) = g(f(x))
  val h = g compose f

  val h_alt = f andThen g

  // operators from ScalaZ
  val hz = g <<< f
  val hz_alt = f >>> g

  /** Higher Ordered Functions */
  val hof1: String => (Int => Int) =
    (str: String) => ((i: Int) => i + str.length)
  val hof2: (String => Int) => Int =
    (f: String => Int) => f("blablalbal")

  val hof1Val: Int => Int = hof1("hello")
  val hof2Val: Int = hof2(_.length)

  /** Curry */
  val threeArgs: (Int, String, Double) => Long =
    (i, s, d) => i.toLong + s.length.toLong + d.toLong
  val curried: Int => String => Double => Long = ???
  val oneArgApplied: String => Double => Long = curried(10)

  /** Parital application */
  val pa1: (String, Double) => Long = threeArgs(10, _:String, _:Double)
  val pa2: (Int, Double) => Long = threeArgs(_:Int, "hi", _:Double)

  /** Functions vs methods */
  class Foo(val str: String) {
    val func: Int => String = _.toString

    def method(i: Int): String = i.toString
  }

  val foo = new Foo("hello")
  foo.func(10)
  foo.method(10)

  // compose f with foo/method 
  
  // compose foo/method with f
}
