package com.wix.talks.oo

object FactoryObjectOriented extends App{

  val dog = AnimalFactory.get("Dog")
  println(s"$dog speak ${dog.speak}")

  val cat = AnimalFactory.get("Cat")
  println(s"$cat speak ${cat.speak}")

  val cow = AnimalFactory.get("Cow")
  println(s"$cow speak ${cow.speak}")
}

object AnimalFactory {
  
  def get(name: String): Animal = 
     if(name == "Dog") 
       Dog()
      else if(name == "Cat")
        Cat()
      else if(name == "Cow")
       Cow()
      else throw UnknownAnimalException()
  
}

trait Animal {
  def speak: String
  
}
case class Dog() extends Animal {
  override def speak: String = "Buff"
}
case class Cat() extends Animal {
  override def speak: String = "Miyaoo"
}
case class Cow() extends Animal{
  override def speak: String = "Moo"
}

case class UnknownAnimalException() extends RuntimeException