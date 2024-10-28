package models

import play.api.libs.json.{Format, Json}

case class UrlAndTitle(url: String,
                       title: String)

object UrlAndTitle {
  implicit val format: Format[UrlAndTitle] = Json.format
}
