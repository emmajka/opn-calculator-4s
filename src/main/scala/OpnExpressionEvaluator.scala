package pl.emmajk

import OpnOperand.*

import scala.annotation.tailrec
import scala.collection.mutable

/*
TODO: replacing mutable.Stack with an immutable version and doing it completely FP-style
* */
case class OpnExpressionEvaluator(opnOpsExecutor: OpnOperationExecutor) {

  def evaluate(opnString: String): Either[OpnException, Double] = {
    val stack = mutable.Stack[Double]()

    @tailrec
    def go(opns: List[String]): Either[OpnException, Double] = {
      opns match {
        case h :: t =>
          opnOpsExecutor.execute(h, stack) match
            case Left(err) => Left(err).withRight[Double]
            case Right(_) => go(t)
        case Nil => Right(stack.pop())
      }
    }

    go(opnString.split(" ").toList)
  }


}

object OpnExpressionEvaluator {
  def apply(): OpnExpressionEvaluator = {
    OpnExpressionEvaluator(opnOpsExecutor = OpnOperationExecutor())
  }
}
