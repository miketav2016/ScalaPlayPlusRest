package models

import play.api.libs.json.{Format, Json}

case class WebLink(links: Seq[String])

object WebLink {
  implicit val format: Format[WebLink] = Json.format
}
