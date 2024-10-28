package models

import play.api.libs.json.{Format, Json}

case class TaskResultOutput(title: Option[String])

object TaskResultOutput {
  implicit val format: Format[TaskResultOutput] = Json.format
}

