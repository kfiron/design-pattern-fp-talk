package com.wix.talks.fp

object StrategyObjectOriented extends App{

  val context = new Context(new OperationMultiply)
  assert(context.execute(3, 4) == 12)
}


trait Strategy {
  def doOperation(i: Int, z: Int): Int
}

class OperationAdd extends Strategy{
  override def doOperation(i: Int, z: Int): Int = i + z
}

class OperationSubstract extends Strategy{
  override def doOperation(i: Int, z: Int): Int = i - z
}

class OperationMultiply extends Strategy{
  override def doOperation(i: Int, z: Int): Int = i * z
}

class Context(strategy: Strategy){  
  def execute(i: Int, z: Int) = strategy.doOperation(i, z)  
}