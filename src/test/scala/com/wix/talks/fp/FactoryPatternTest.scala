package com.wix.talks.fp

import org.specs2.mutable.SpecificationWithJUnit

class FactoryPatternTest extends SpecificationWithJUnit{
  
  "factory pattern" should {
    "object oriented usage" in {
      val dog: Animal = AnimalFactory.get("dog")
      dog.noise must beEqualTo("bark")

      val cat: Animal = AnimalFactory.get("cat")
      cat.noise must beEqualTo("miyaoo")
    }
    "fp oriented usage" in {
      val dog: Animal = AnimalFactoryFP("dog")
      dog.noise must beEqualTo("bark")

      val cat: Animal = AnimalFactoryFP("cat")
      cat.noise must beEqualTo("miyaoo")
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
