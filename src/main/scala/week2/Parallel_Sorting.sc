//Merge Sort
/*
The parallel merge sort algorithm will be implemented

1. recursively sort the two halves of the array in parallel.
2. sequentially merge the two array halves by copying into a temporary array
3. copy the temporary array back into the original array

The parMergeSort method takes an array, and a maximum depth:
*/


val ys = new Array[Int](xs.length)

def merge(src: Array[Int], dst: Array[Int], from: Int, mid: Int, until: Int): Unit

def sort(from: Int, until: Int, depth: Int): Unit = {
  if (depth == maxDepth){
    quickSort(xs, from, until - from)
  }else{
    val mid = (from + until) / 2
    parallel(sort(mid, until, depth + 1), sort(from, mid, depth + 1))

    val flip = (maxDepth - depth) % 2 == 0
    val src = if (flip) ys else xs
    val dst = if (flip) xs else ys
    merge(src, dst, from, mid, until)
  }
}
sort(0, xs.length, 0)

// Copying the Array
def copy(src: Array[Int], target: Array[Int],
         from: Int, until: Int, depth: Int): Unit = {
  if (depth == maxDepth){
    Array.copy(src, from, target, from, until - from)
  }else{
    val mid = (from + until) / 2
    val right = parallel(
      copy(src, target, mid, until, depth + 1),
      copy(src, target, from, mid, depth + 1)
    )
  }

}



