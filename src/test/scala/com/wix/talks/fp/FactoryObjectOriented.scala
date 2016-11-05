package com.wix.talks.fp

object FactoryObjectOriented extends App{

  val dog = AnimalFactory.get("Dog")
  println(s"I am a $dog")

  val cat = AnimalFactory.get("Cat")
  println(s"I am a $cat")

  val cow = AnimalFactory.get("Cow")
  println(s"I am a $cow")
  
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

trait Animal
case class Dog() extends Animal
case class Cat() extends Animal
case class Cow() extends Animal

case class UnknownAnimalException() extends RuntimeException