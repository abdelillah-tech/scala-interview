package com.particeep.test

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

case class CEO(id: String, first_name: String, last_name: String)
case class Enterprise(id: String, name: String, ceo_id: String)

object CEODao {
  val ceos = List(
    CEO("1", "Mark", "Zuckerberg"),
    CEO("2", "Sundar", "Pichai")
  )

  def byId(id: String): Future[Option[CEO]] = Future { ceos.find(_.id == id) }
}

object EnterpriseDao {
  val enterprises = List(
    Enterprise("1", "Google", "1"),
    Enterprise("2", "Facebook", "2")  //the first thing i see is the values in ceo.id column they should be swaped
  )

  def byId(id: String): Future[Option[Enterprise]] = Future { enterprises.find(_.id == id) }
  def byCEOId(ceo_id: String): Future[Option[Enterprise]] = Future { enterprises.find(_.ceo_id == ceo_id) }
}

object WhatsWrong2 {

  //Review this code. What could be done better ? How would you do it ?
  def getCEOAndEnterprise(ceo_id: Option[String]): Future[(Option[CEO], Option[Enterprise])] = {
    for {
      ceo <- CEODao.byId(ceo_id.get)                      // if we call sequentially several external resources it can turn out into a problem
      enterprise <- EnterpriseDao.byCEOId(ceo_id.get)     // but i'm not sur of what the replacement could be
    } yield {
      (ceo, enterprise)
    }
  }
}
