println("New anonymous Strategy - Inline")

trait TaxStrategy {
  val taxRate = 0.30

  def calculate(age: Long): Double
}

class MahaTaxStrategy extends TaxStrategy {
  def calculate(income: Long): Double = income * taxRate
}

class DelhiTaxStrategy extends TaxStrategy {
  override val taxRate = 0.20

  def calculate(income: Long): Double = income * taxRate
}

case class Person(age: Int, income: Long = 0) {
  def isAdult = if (age > 18) true else false

  def getTaxAmount(strategy: TaxStrategy): Double = if (isAdult) strategy.calculate(income) else 0D
}

val p2 = Person(20, 10000)

p2.getTaxAmount(new TaxStrategy {
  def calculate(income: Long): Double = income * taxRate
})
