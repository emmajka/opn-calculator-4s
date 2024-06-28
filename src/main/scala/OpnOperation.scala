package pl.emmajk

import OpnException.*

import scala.collection.mutable

/* 
TODO: each method could be extracted to separate classes, additional inheritance could be added depending on operation type,
as in unary, binary, n-ary operation etc. with additional validations as in binary require at least 2 elements on stack,
unary needs just 1 element and n-ary needs n elements
TODO #2: tests on failures
 */
case class OpnOperation() {

  def add(stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    val num1 = stack.pop()
    val num2 = stack.pop()
    stack.push(num2 + num1)
    Right(())
  }

  def subtract(stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    val num1 = stack.pop()
    val num2 = stack.pop()
    stack.push(num2 - num1)
    Right(())
  }

  def multiply(stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    val num1 = stack.pop()
    val num2 = stack.pop()
    stack.push(num2 * num1)
    Right(())
  }

  def divide(stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    val num1 = stack.pop()
    val num2 = stack.pop()
    if num1 == 0 then Left(DivideByZero)
    else {
      stack.push(num2 / num1)
      Right(())
    }
  }

  def abs(stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    val num = stack.pop()
    stack.push(math.abs(num))
    Right(())
  }

  def max(stack: mutable.Stack[Double]): Either[OpnException, Unit] = {
    val maxNum = stack.reduceLeft((maximum, current) => maximum.max(current))
    stack.clear()
    stack.push(maxNum)
    Right(())
  }

  def push(stack: mutable.Stack[Double], value: String): Either[OpnException, Unit] = {
    value.toDoubleOption match
      case Some(num) =>
        stack.push(num)
        Right(())
      case None => Left(NonNumericValue(value))
  }
}
