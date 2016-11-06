package com.wix.talks.fp

object BuilderFp extends App{

  val pizza = Pizza2(name = "Putaneska", 
                      size = Medium,
                      toppings = Seq("Anshobi", "Olives"),
                      dough = SourDough)
  
  println(pizza)
}


case class Pizza2(name: String = "Margarigta",
                 size: PizzaSize = Large,
                  toppings: Seq[String] = Seq.empty[String],
                  dough: Dough)