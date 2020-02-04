// Example starting threads
class HelloThread extends Thread{
  override def run(): Unit ={
    println("Hello world!")
  }
}

val t = new HelloThread

t.start()
t.join()














