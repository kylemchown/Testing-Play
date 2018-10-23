package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new srdtgh is ready."))
  }

  def copyindex = Action {
    Ok(views.html.copyindex("srjjiehjeksjrhb"))
  }

  def copyind(id: Long = 12345) = Action {
    Ok(views.html.copyindex(id.toString))
  }

  def toHome= Action { implicit request:
  Request[AnyContent] =>
    Redirect("/")
  }

}