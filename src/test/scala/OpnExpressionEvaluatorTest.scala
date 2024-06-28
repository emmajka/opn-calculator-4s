package pl.emmajk

import org.scalatest.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.prop.TableDrivenPropertyChecks.*
import org.scalatest.prop.Tables.Table

class OpnExpressionEvaluatorTest extends AnyFlatSpec {

  private val testData = Table(
    ("OPN string", "expected result"),
    ("1 1 +", 2.0),
    ("1 -1 abs +", 2.0),
    ("1 2 +", 3.0),
    ("1 2 max", 2.0),
    ("1 2 -", -1.0),
    ("2 1 -", 1.0),
    ("2 3 + 5 x", 25.0),
    ("2 -3 abs + 5 x", 25.0),
    ("2 -3 abs max 1 + 5 x", 20.0),
    ("12 2 3 4 x 10 5 / + x +", 40.0),
    ("5 1 2 + 4 x + 3 -", 14.0),
  )

  val sut = OpnExpressionEvaluator()

  "evaluating opn string" should "return expected result" in {
    forEvery(testData) { case (opnString: String, expectedResult) => sut.evaluate(opnString).map(result => result shouldBe expectedResult).getOrElse(Assertions.fail()) }
  }

}
