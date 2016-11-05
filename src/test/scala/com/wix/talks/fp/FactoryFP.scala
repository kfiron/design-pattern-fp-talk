package com.wix.talks.fp


object FactoryFP extends App{

  val dog = AnimalFactory.get("Dog")
  println(s"I am a $dog")

  val cat = AnimalFactory.get("Cat")
  println(s"I am a $cat")

  val cow = AnimalFactory.get("Cow")
  println(s"I am a $cow")
  
}

object AnimalFactoryFp {
  def apply(animal: String): Animal = animal match {
    case "Dog" => Dog()
    case "Cat" => Cat()
    case "Cow" => Cow()
    case _ => throw UnknownAnimalException()
  }
  
}
