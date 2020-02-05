// Sum of powers of array segment: solution
// The main function is
def sumSegment(a: Array[Int], p: Double, s: Int, t: Int): Int = {
  var i = s; var sum: Int = 0
  while (i < t) {
    sum = sum + power(a(i), p)
    i = i + 1
  }
  sum
}
// Here power computes
def power(x: Int, p: Double): Int = math.exp(p * math.log(abs(x))).toInt

// Is there a recursive algorithm for an unbounded of threads ?
def pNormRec(a: Array[Int], p: Double): Int =
  power(segmentRec(a, p, 0, a.length), 1/p)

// like sumSegment but parallel
def segmentRec(a: Array[Int], p: Double, s: Int, t: Int) = {
  if (t - s < threshold)
    sumSegment(a, p, s, t)  // small segment: do it sequentially
  else{
    val m = s + (t - s) / 2
    val (sum1, sum2) = parallel(segmentRec(a, p, s, m),
                                segmentRec(a, p, m, t))
    sum1 + sum2
  }
}

















