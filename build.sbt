import play.sbt.PlayScala

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """scala-play-plus-rest""",
    organization := "com.example",
    version := "1.0-SNAPSHOT",
    crossScalaVersions := Seq("2.13.14"),
    scalaVersion := crossScalaVersions.value.head,
    libraryDependencies ++= Seq(
      guice,
      ws
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-Werror"
    )
  )
