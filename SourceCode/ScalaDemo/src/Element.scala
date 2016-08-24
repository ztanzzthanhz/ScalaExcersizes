/**
  * Created by thanhdt3 on 8/24/2016.
  */
abstract class Element {
  def contents: Array[String] // no body : abstract
  val height: Int = contents.length
  val width: Int =
    if (height == 0) 0 else contents(0).length

  def checkEqual(that: Element): Boolean =
    if (height != that.height || width != that.width) false
    else if (contents.mkString == that.contents.mkString) true
    else false
}

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts

}

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override val width = s.length
  override val height = 1
}

class UniformElement(c: Char, h: Int, w: Int) extends Element {
  def contents: Array[String] = Array.fill(h)(List.fill(w)(c).mkString)

}

object Element {
  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(line: String): Element =
    new LineElement(line)

  def elem(c: Char, h: Int, w: Int): UniformElement =
    new UniformElement(c, h, w)
}