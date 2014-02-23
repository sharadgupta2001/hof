println("The java way - Scala syntax")

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

val p1 = new Person(30, 10000)

p1.getTaxAmount(new MahaTaxStrategy)

val p2 = p1.copy(age = 20)

p2.getTaxAmount(new DelhiTaxStrategy)


