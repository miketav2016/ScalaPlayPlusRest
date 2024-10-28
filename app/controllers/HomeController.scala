package controllers


import models.{TaskResultOutput, WebLink}
import play.api.libs.json._
import play.api.libs.ws.WSClient
import play.api.mvc._
import restApi.RestController

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
class HomeController @Inject()(val controllerComponents: ControllerComponents,
                               restController: RestController)(implicit ex: ExecutionContext, wsClient: WSClient) extends BaseController {


  implicit private val webLinkDTOFormat: Format[WebLink] = Json.format

  def ping(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("pong")
  }

  def resTest(): Action[AnyContent] = Action.async { implicit request: Request[AnyContent] =>
    val testUrl = "https://cdn.cookielaw.org/consent/c3d9f1e3-55f3-4eba-b268-46cee4c6789c/c3d9f1e3-55f3-4eba-b268-46cee4c6789c.json"
    val testUrl1 = "https://ot.gov.ru/api/mandatoryRequirement/b9426550-ec81-46d8-b8e1-6659811ddaa3"
    val res = restController.waitForTask(testUrl1)
    res.map(item => Ok(Json.toJson(item)))
  }


  def searchTitle: Action[JsValue] = Action.async(parse.json[JsValue]) { request =>
    val links = Json.parse(request.body.toString()).as[WebLink].links
    val seqTitleF = for {
      titles <- links.map(restController.waitForTask)
    } yield titles
    val fSeqTitle = Future.sequence(seqTitleF)
    fSeqTitle.map(seq => Ok(Json.toJson(seq)))
  }
}
