package com.wix.talks.fp

object StrategyFP extends App{

  assert(execute(multiply, 3, 4) == 12)
  val pa = execute2(add) _
  assert(pa(2, 4) == 6)
  
  def add(i: Int, z: Int) = i + z
  def subtract(i: Int, z: Int) = i - z
  def multiply(i: Int, z: Int) = i * z
  
  def execute(f: (Int, Int) => Int, x: Int, y: Int): Int = f(x, y)
  def execute2(f: (Int, Int) => Int)( x: Int, y: Int): Int = f(x, y)
  
}


