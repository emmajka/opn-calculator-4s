package pl.emmajk

enum OpnException(cause: String) {
  case NonNumericValue(value: String) extends OpnException(cause = s"Invalid numeric value provided: [$value]")
  case DivideByZero extends OpnException(cause = s"Division by zero is forbidden!")
  case UncaughtException(t: Throwable) extends OpnException(cause = s"An unexpected exception occurred during OPN evaluation: ${t.getMessage }")
}