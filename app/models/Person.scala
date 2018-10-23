package models

import play.api.data._
import play.api.data.Forms._

import scala.collection.mutable.ArrayBuffer

case class Person(fname: String, lname: String)

object Person{
  val createPersonForm = Form(
    mapping(
      "fname" -> nonEmptyText,
      "lname" -> nonEmptyText
    )(Person.apply)(Person.unapply)
  )

  val people = ArrayBuffer(
    Person("John", "Smith"),
    Person("Abc", "123")
  )


}
