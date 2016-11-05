package com.wix.talks.fp


object FactoryFP extends App{

  val dog = AnimalFactoryFp("Dog")
  println(s"$dog speak ${dog.speak}")

  val cat = AnimalFactoryFp("Cat")
  println(s"$cat speak ${cat.speak}")

  val cow = AnimalFactoryFp("Cow")
  println(s"$cow speak ${cow.speak}")
  
}

object AnimalFactoryFp {
  def apply(animal: String): Animal = animal match {
    case "Dog" => Dog()
    case "Cat" => Cat()
    case "Cow" => Cow()
    case _ => throw UnknownAnimalException()
  }
  
}
