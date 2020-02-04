// Example starting threads
//class HelloThread extends Thread{
//  override def run(): Unit ={
//    println("Hello world!")
//  }
//}
//
//val t = new HelloThread
//
//t.start()
//t.join()

//
//// Slightly different example
//class HelloThread2 extends Thread{
//  override def run(){
//    println("Hello ")
//    println("world!")
//  }
//}
//
//def main(): Unit ={
//  val t = new HelloThread2()
//  val s = new HelloThread2()
//
//  t.start()
//  s.start()
//  t.join()
//  s.join()
//}
//
//main()
//main()
//
//main()
//main()

// Atomicity

// An operation is atomic if it appears as if it occurred
// instantaneously from the point of view of other threads.
//var uidCount = 0L
//
//def getUniqueId(): Long = {
//  uidCount = uidCount + 1
//  uidCount
//}
//
//def startThread() = {
//  val t = new Thread{
//    override def run(): Unit ={
//      val uids = for (i <- 0 until 10) yield getUniqueId()
//      println(uids)
//    }
//  }
//  t.start()
//  t
//}
//startThread(); startThread()

// The synchronized block

// TThe synchronized block is used to achieve atomicity.
// Code block after a synchronized call on an object x
// is never executed by two threads at the same time.

val x = new AnyRef {}
var uidCount = 0L
def getUniqueId(): Long = x.synchronized {
  uidCount = uidCount + 1
  uidCount
}

def startThread() = {
  val t = new Thread{
    override def run(): Unit ={
      val uids = for (i <- 0 until 10) yield getUniqueId()
      println(uids)
    }
  }
  t.start()
  t
}
startThread(); startThread()

// Using the same code from above with the synchronized
// bite ensures the output will not be duplicated









