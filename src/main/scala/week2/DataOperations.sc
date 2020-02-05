// Map as function on lists

// Sequential definition:
def mapSeq[A, B](lst: List[A], f: A => B): List[B] = lst match {
  case Nil => Nil
  case h :: t => f(h) :: mapSeq(t, f)
}

















