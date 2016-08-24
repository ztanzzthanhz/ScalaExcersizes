/**
  * Created by thanhdt3 on 8/24/2016.
  */
class Rational(n: Int , d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  val numer = n / g
  val denom = d / g

  def this(n: Int) = this(n, 1)
  def this() = this(0)

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  def + (number: Int): Rational = this + new Rational(number)
  def * (that: Rational): Rational =
    new Rational(
      numer * that.numer,
      denom * that.denom
    )
  def * (number: Int): Rational = this * new Rational(number)

  override def toString = numer + "/" + denom
}

