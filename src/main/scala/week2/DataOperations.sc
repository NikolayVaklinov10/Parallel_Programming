// Map as function on lists

//// Sequential definition:
//def mapSeq[A, B](lst: List[A], f: A => B): List[B] = lst match {
//  case Nil => Nil
//  case h :: t => f(h) :: mapSeq(t, f)
//}



def Greeting(name:String, age:Int) = {
  println(s"Hi, my name is $name and I am $age years old")
}

Greeting("Nikolay", 30)


def Factorial(number:Int):BigInt = {
  def factHelper(x:Int, accumulator:BigInt):BigInt =
  if (number <= 1) accumulator
  else factHelper(x - 1, x * accumulator)
  factHelper(number, 1)
}
Factorial(5)

def Fibonacci(n:Int):Int = {
  if (n <= 2) 1
  else Fibonacci(n - 1) + Fibonacci(n - 2)
}
Fibonacci(7)

def isPrime(n:Int):Boolean = {
  def isPrimeUntil(t: Int): Boolean =
    if (t <= 1) true
    else n % t != 0 && isPrimeUntil(t - 1)
  isPrimeUntil(n / 2)
}

isPrime(2003)

