var uidCount = 0L

def getUniqueId(): Long = {
  uidCount = uidCount + 1
  uidCount
}

// Composition with the synchronized block

// Invocations of the synchronized block can be nested.

class Account(private var amount: Int = 0){
  def transfer(target: Account, n: Int) =
    this.synchronized{
      target.synchronized{
        this.amount -= n
        target.amount += n
      }
    }
}

def startThread(a: Account, b: Account, n: Int) = {
  val t = new Thread {
    override def run(): Unit ={
      for (i <- 0 until n) {
        a.transfer(b, 1)
      }
    }
  }
  t.start()
}

val a1 = new Account(500000)
val a2 = new Account(700000)

val t = startThread(a1, a2, 150000)
val s = startThread(a2, a1, 150000)
t.join()
s.join()

//The above code never stops

// Resolving deadlocks

// One approach is to always acquire resources in the same order.
// This assumes an ordering relationship on the resources.

val  uid = getUniqueId()
def lockAndTransfer(target: Account, n: Int) =
  this.synchronized {
    target.synchronized{
      this.amount -= n
      target.amount += n
    }
  }

def transfer(target: Account, n: Int) =
  if (this.uid < target.uid) this.lockAndTransfer(target, n)
else target.lockAndTransfer(this, -n)





















