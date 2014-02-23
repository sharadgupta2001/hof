println("Scala Function1 - Syntactic sugar : short and infix notation")

class MahaTaxStrategy extends (Long => Double) {
  val taxRate = 0.30

  def apply(income: Long): Double = income * taxRate
}

class DelhiTaxStrategy extends (Long Function1 Double) {
  val taxRate = 0.20

  def apply(income: Long): Double = income * taxRate
}

case class Person(age: Int, income: Long = 0) {
  def isAdult = if (age > 18) true else false

  def getTaxAmount(strategy: Function1[Long, Double]): Double = if (isAdult) strategy(income) else 0D
}

val p2 = Person(20, 10000)

p2.getTaxAmount(new MahaTaxStrategy)

}