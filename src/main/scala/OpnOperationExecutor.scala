package pl.emmajk

import OpnException.UncaughtException
import OpnOperand.*

import scala.collection.mutable
import scala.util.{Failure, Success, Try}

/*
 TODO: tests, mocking and so on.
*/
case class OpnOperationExecutor(opnOperation: OpnOperation) {
  def execute(value: String, stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    def go(str: String) = {
      str match
        case Add.op => opnOperation.add(stack)
        case Subtract.op => opnOperation.subtract(stack)
        case Multiply.op => opnOperation.multiply(stack)
        case Divide.op => opnOperation.divide(stack)
        case Abs.op => opnOperation.abs(stack)
        case Max.op => opnOperation.max(stack)
        case other => opnOperation.push(stack, other)
    }

    Try(go(value)) match
      case Failure(exception) => Left(UncaughtException(exception))
      case Success(result) => result
  }
}

object OpnOperationExecutor {
  def apply(): OpnOperationExecutor = {
    OpnOperationExecutor(opnOperation = OpnOperation())
  }
}