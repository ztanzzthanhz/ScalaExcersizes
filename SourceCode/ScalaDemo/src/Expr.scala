/**
  * Created by thanhdt3 on 8/24/2016.
  */
abstract class Expr {
  def eval: Number
}

case class Var(name: String) extends Expr {
  def eval: Number = null

  override def toString: String = name
}

case class Number(num: Double) extends Expr {
  def eval : Number = this

  override def toString: String = num.toString
}

case class UnOp(operator: String, arg: Expr) extends Expr {
  def eval : Number =
    if (operator == "-") Number(-arg.eval.num)
    else arg.eval

  override def toString: String = "(" + operator + arg.toString + ")"
}

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr {
  def eval : Number = operator match {
    case "+" => Number(left.eval.num + right.eval.num)
    case "-" => Number(left.eval.num - right.eval.num)
    case "*" => Number(left.eval.num * right.eval.num)
    case "/" => Number(left.eval.num / right.eval.num)
  }

  override def toString: String = "(" + left.toString + operator + right.toString + ")"
}
