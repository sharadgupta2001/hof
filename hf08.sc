println("Going Functional - Def(Method) and Val(Function) ")


val mahaTaxStrategy = {
  (income: Long) => income * 0.30
}

def delhiTaxStrategy(income: Long): Double = income * 0.20

case class Person(age: Int, income: Long = 0) {
  def isAdult = if (age > 18) true else false

  def getTaxAmount(strategy: (Long) => Double): Double = if (isAdult) strategy(income) else 0D
}

val p2 = Person(20, 10000)

p2.getTaxAmount(mahaTaxStrategy)

p2.getTaxAmount(income => mahaTaxStrategy(income))
