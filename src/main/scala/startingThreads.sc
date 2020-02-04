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


// Slightly different example
class HelloThread2 extends Thread{
  override def run(){
    println("Hello ")
    println("world!")
  }
}

def main(): Unit ={
  val t = new HelloThread2()
  val s = new HelloThread2()

  t.start()
  s.start()
  t.join()
  s.join()
}

main()
main()

main()
main()









