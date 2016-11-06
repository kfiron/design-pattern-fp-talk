package com.wix.talks.fp

object BuilderObjectOriented extends App{

  val pizza = new PizzaBuilder()
                .withDough(Full)
                .withName("Putaneska")
                .withToppings(Seq("Anshobi", "olives"))
                .withSize(Large)
                .build
  
  println(pizza)
}

case class Pizza(name: String,
                  toppings: Seq[String],
                  dough: Dough,
                  size: PizzaSize)

class PizzaBuilder {
  
  private var name: String = "Margarita"
  private var toppings = Seq.empty[String]
  private var dough: Dough = White
  private var size: PizzaSize = Small
  
  def withName(name: String) = {
    this.name = name
    this
  }
  
  def withToppings(toppings: Seq[String]) = {
    this.toppings = toppings
    this    
  }
  
  def withDough(dough: Dough) = {
    this.dough = dough
    this    
  }
  
  def withSize(size: PizzaSize) = {
    this.size = size
    this    
  }
  
  def build : Pizza = new Pizza(this.name,
                                this.toppings,
                                this.dough, 
                                 this.size)
  
}

sealed trait Dough
case object Full extends Dough
case object White extends Dough
case object SourDough extends Dough

sealed trait PizzaSize
case object Small extends PizzaSize
case object Medium extends PizzaSize
case object Large extends PizzaSize