package com.wix.talks.fp

import com.wix.talks.oo._


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