/**
  * Created by thanhdt3 on 8/17/2016.
  */
object ScalaApp {
  def main(args: Array[String]): Unit = {
    TestRational
    TestUnitElement
    TestExpr
    TestQueue
  }

  def TestRational {
    val r = new Rational(1, 2)
    val r2 = r + 3

    println(r2)
  }

  def TestUnitElement {
    val x = Element.elem(Array("ccc", "ccc"))
    val y = Element.elem('d', 0, 0)
    val z = new ArrayElement(Array())

    val b = y.checkEqual(z)
    println(b)
  }

  def TestExpr {
    val a = BinOp("*", BinOp("+", Var("x"), Number(1.2)), Number(4))
    println(a)

    val t = BinOp("*", Number(1.2), Number(2))
    println(t.eval)
  }

  def TestQueue {
    val queue = new BasicIntQueue with Doubling with EvenFilter

    queue.put(2)
    queue.put(3)
    queue.put(4)
    println(queue.get)
    println(queue.get)
  }
}
