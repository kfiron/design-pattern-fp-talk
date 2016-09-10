package com.wix.talks.fp

import org.specs2.mutable.SpecificationWithJUnit

class FactoryPatternTest extends SpecificationWithJUnit{
  
  "factory pattern" should {
    "object oriented usage" in {
      val animal = AnimalFactory.get("dog")
      animal.noise must beEqualTo("bark")

      val anotherAnimal = AnimalFactory.get("cat")
      anotherAnimal.noise must beEqualTo("miyaoo")
    }
    "fp oriented usage" in {
      val animal = AnimalFactoryFP("dog")
      animal.noise must beEqualTo("bark")

      val anotherAnimal = AnimalFactoryFP("cat")
      anotherAnimal.noise must beEqualTo("miyaoo")
    }
  }

}

sealed trait Animal{
  def noise: String
}

case class Dog() extends Animal {
  override def noise: String = "bark"
}

case class Cat() extends Animal {
  override def noise: String = "miyaoo"
}


object AnimalFactory {
  def get(animal: String): Animal = {
    if(animal == "dog") {
      Dog()
    } else if(animal == "cat"){
      Cat()
    } else ???
  }
}

object AnimalFactoryFP{
  def apply(animal: String): Animal = animal match {
    case "dog" => Dog()
    case "cat" => Cat()
  }
}
