package controllers

import javax.inject.Inject
import play.api._
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._
import models.Person

class Application @Inject()(val messagesApi: MessagesApi, environment: play.api.Environment) extends Controller with I18nSupport {

  def listPeople = Action { implicit request =>
    Ok(views.html.listPeople(Person.people, Person.createPersonForm))
  }


  def createPerson = Action { implicit request =>
    val formValidationResult = Person.createPersonForm.bindFromRequest

    formValidationResult.fold({ formWithErrors =>
      BadRequest(views.html.listPeople(Person.people, formWithErrors))
    }, { newPerson =>
      println("get in here")
      Person.people.append(newPerson)
      Redirect(routes.Application.listPeople)
    })
  }



  def index = Action {
    Ok(views.html.index("Your new srdtgh is ready."))
  }

  def copyindex = Action {
    Ok(views.html.copyindex("srjjiehjeksjrhb"))
  }


  def copyind(id: Long = 12345) = Action {
    Ok(views.html.copyindex(id.toString))
  }

  def listTest = Action {
    Ok(views.html.listTest("a"))
  }

  def toHome= Action { implicit request:
  Request[AnyContent] =>
    Redirect("/")
  }

  def notFound= Action {
    NotFound(<h1>Page not found</h1>)
  }

  def badReq= Action {
    BadRequest("You dun goofed")
  }




}