package pl.emmajk

import org.scalatest.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.prop.TableDrivenPropertyChecks.*
import org.scalatest.prop.Tables.Table

import scala.collection.mutable

class OpnOperationTest extends AnyFlatSpec {

  private val addTestData = Table(
    ("Numeric value", "expected result"),
    (mutable.Stack(1.0, 1.0), 2.0),
    (mutable.Stack(1.0, 3.0), 4.0),
    (mutable.Stack(-1.0, 1.0), 0.0),
    (mutable.Stack(-1.0, -1.0), -2.0),
  )

  val sut = OpnOperation()

  "calling ADD operation with correct data" should "return correct result" in {
    forEvery(addTestData) { case (stack: mutable.Stack[Double], expectedResult) =>
      sut.add(stack)
      stack.pop() shouldBe expectedResult
    }
  }


  private val subtractTestData = Table(
    ("Numeric value", "expected result"),
    (mutable.Stack(3.0, 1.0), -2.0),
    (mutable.Stack(1.0, 3.0), 2.0),
    (mutable.Stack(-1.0, 1.0), 2.0),
    (mutable.Stack(-1.0, -1.0), -0.0),
  )

  "calling SUBTRACT operation with correct data" should "return correct result" in {
    forEvery(subtractTestData) { case (stack: mutable.Stack[Double], expectedResult) =>
      sut.subtract(stack)
      stack.pop() shouldBe expectedResult
    }
  }

  private val multiplyTestData = Table(
    ("Numeric value", "expected result"),
    (mutable.Stack(3.0, 1.0), 3.0),
    (mutable.Stack(1.0, 3.0), 3.0),
    (mutable.Stack(-1.0, 1.0), -1.0),
    (mutable.Stack(-1.0, -1.0), 1.0),
    (mutable.Stack(-7.0, -2.0), 14.0),
    (mutable.Stack(7.0, -2.0), -14.0),
  )

  "calling MULTIPLY operation with correct data" should "return correct result" in {
    forEvery(multiplyTestData) { case (stack: mutable.Stack[Double], expectedResult) =>
      sut.multiply(stack)
      stack.pop() shouldBe expectedResult
    }
  }

  private val divideTestData = Table(
    ("Numeric value", "expected result"),
    (mutable.Stack(2.0, 1.0), 0.5),
    (mutable.Stack(1.0, 2.0), 2.0),
    (mutable.Stack(-1.0, 1.0), -1.0),
    (mutable.Stack(-1.0, -1.0), 1.0),
    (mutable.Stack(-4.0, -2.0), 0.5),
    (mutable.Stack(2.0, -4.0), -2.0),
  )

  "calling DIVIDE operation with correct data" should "return correct result" in {
    forEvery(divideTestData) { case (stack: mutable.Stack[Double], expectedResult) =>
      sut.divide(stack)
      stack.pop() shouldBe expectedResult
    }
  }
  private val absTestData = Table(
    ("Numeric value", "expected result"),
    (mutable.Stack(2.0, 1.0), mutable.Stack(2.0, 1.0)),
    (mutable.Stack(2.0, -1.0), mutable.Stack(2.0, -1.0)),
    (mutable.Stack(-11.0), mutable.Stack(11.0)),
    (mutable.Stack(-2.0, -1.0, -2.0), mutable.Stack(2.0, -1.0, -2.0)),
  )

  "calling ABS operation with correct data" should "return correct result" in {
    forEvery(absTestData) { case (stack: mutable.Stack[Double], expectedResult) =>
      sut.abs(stack)
      assert(stack == expectedResult)
    }
  }
  private val maxTestData = Table(
    ("Numeric value", "expected result"),
    (mutable.Stack(2.0, 1.0), mutable.Stack(2.0)),
    (mutable.Stack(2.0, -1.0), mutable.Stack(2.0)),
    (mutable.Stack(-11.0), mutable.Stack(-11.0)),
    (mutable.Stack(-2.0, -1.0, -2.0), mutable.Stack(-1.0)),
    (mutable.Stack(17.0, -33.0, 24.0), mutable.Stack(24.0)),
    (mutable.Stack(24.0, 33.0, -24.0), mutable.Stack(33.0)),
  )

  "calling MAX operation with correct data" should "return correct result" in {
    forEvery(maxTestData) { case (stack: mutable.Stack[Double], expectedResult) =>
      sut.max(stack)
      assert(stack == expectedResult)
    }
  }
}
