package week2

import scala.annotation.tailrec

object Recursion extends App {


def factorial(n: Int):Int =
  if (n <= 1) 1
  else {
    println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
    val result = n * factorial(n - 1)
    n * factorial(n - 1)

    result
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x < 1) accumulator
      else factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }



  //println(factorial(10))
  println(anotherFactorial(5000))

  // Converting the functions into Tailrec

  //the concatenation function
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  println(concatenateTailrec("hello", 3,""))

  //the prime function
  def isPrime(n: Int): Boolean ={
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t -1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  //the fibonacci
  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, accumulator1: Int, accumulator2: Int):Int =
      if (i >= n) accumulator1
      else fiboTailrec(i + 1, accumulator1 + accumulator2, accumulator1)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8))
  println(isPrime(2003))






}
