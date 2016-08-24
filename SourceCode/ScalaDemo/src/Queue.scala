import scala.collection.mutable.ArrayBuffer

/**
  * Created by thanhdt3 on 8/24/2016.
  */
abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait EvenFilter extends IntQueue {
  abstract override def put(x: Int) {
    if (x % 2 == 0)
      super.put(x)
  }
}