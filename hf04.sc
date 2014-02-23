println("Generic Strategy - Anonymous")

trait TaxStrategy[P, R] {
  val taxRate = 0.30

  def calculate(age: P): R
}

class MahaTaxStrategy extends TaxStrategy[Long, Double] {
  def calculate(income: Long): Double = income * taxRate
}

class DelhiTaxStrategy extends TaxStrategy[Long, Double] {
  override val taxRate = 0.20

  def calculate(income: Long): Double = income * taxRate
}

case class Person(age: Int, income: Long = 0) {
  def isAdult = if (age > 18) true else false

  def getTaxAmount(strategy: TaxStrategy[Long, Double]): Double = if (isAdult) strategy.calculate(income) else 0D
}

val p2 = Person(20, 10000)

p2.getTaxAmount(new MahaTaxStrategy)

p2.getTaxAmount(new TaxStrategy[Long, Double] {
  override val taxRate = 0.15

  def calculate(income: Long): Double = income * taxRate
})


