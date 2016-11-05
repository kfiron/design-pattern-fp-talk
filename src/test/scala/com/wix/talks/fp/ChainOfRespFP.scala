package com.wix.talks.fp


// Without side effects
object ChainOfRespFP extends App{

  val kidHandler: PartialFunction[Int, String] = {
    case age if age < 10 => "Take to school"
  }

  val teenAgeHandler: PartialFunction[Int, String] = {
    case age if age >= 10 && age <40 => "Going to party"
  }

  val oldManHandler: PartialFunction[Int, String] = {
    case age if age >= 40 => "Go to hospital for check ups"
  }
  
  val chain = kidHandler orElse teenAgeHandler orElse oldManHandler
  
  Seq(4, 22, 33, 65) foreach {
    age => println(chain(age))
  }

  
  
}


