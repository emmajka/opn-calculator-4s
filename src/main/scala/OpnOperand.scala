package pl.emmajk


// TODO: instead of String's a Regex expression could be used to include x and * as multiply signs and so on.
enum OpnOperand(val op: String) {
  case Add extends OpnOperand("+")
  case Subtract extends OpnOperand("-")
  case Multiply extends OpnOperand("x")
  case Divide extends OpnOperand("/")
  case Abs extends OpnOperand("abs")
  case Max extends OpnOperand("max")
}
