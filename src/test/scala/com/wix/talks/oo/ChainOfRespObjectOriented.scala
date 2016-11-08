package com.wix.talks.oo

object ChainOfRespObjectOriented extends App {

  val kid = new KidHumanHumanHelper
  val teenAge = new TeenAgeHumanHelper
  val oldMan = new OldManHumenHelper
  kid.successor = teenAge
  teenAge.successor = oldMan

  Seq(9, 22, 44, 65) foreach {
    age => kid.processRequest(age)
    
  }

}

abstract class HumanHelper() {
  
  var successor: HumanHelper = _
  def processRequest(age: Int): Unit
}

class KidHumanHumanHelper extends HumanHelper {
  override def processRequest(age: Int): Unit =
    if (age < 10) {
      println("Take to school")
    } else if(successor != null) successor.processRequest(age)
}

class TeenAgeHumanHelper extends HumanHelper {
  override def processRequest(age: Int): Unit =
    if (age >= 10 && age < 40) {
      println("Going to party")
    } else if(successor != null) successor.processRequest(age)
}

class OldManHumenHelper extends HumanHelper {
  override def processRequest(age: Int): Unit =
    if (age >= 40) {
      println("Take to hospital for check up")
    } else if(successor != null) successor.processRequest(age)
}