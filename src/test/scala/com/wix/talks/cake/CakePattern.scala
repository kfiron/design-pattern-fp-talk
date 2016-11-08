package com.wix.talks.cake

import java.util.UUID



object CakePattern {
  val u = new UsersServiceImpl with UsersDaoMySql
}



case class User(id: UUID, email: String)

trait UsersDao {
  def byId(id: UUID): User
}

trait UsersDaoMySql extends UsersDao{
  override def byId(id: UUID): User = ??? // bring from database
}

trait UsersService {
  def emailById(id: UUID): String
}

trait UsersServiceImpl extends UsersService {
  self: UsersDao =>

  override def emailById(id: UUID): String = {
    byId(id).email
  }
}




