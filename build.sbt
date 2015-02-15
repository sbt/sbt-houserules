lazy val commonSettings = Seq(
  organization := "org.scala-sbt",
  version := "0.1.0-SNAPSHOT"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings ++
    addSbtPlugin("com.typesafe.sbt" % "sbt-scalariform" % "1.3.0") ++
    addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.6.1")
  : _*).
  settings(
    sbtPlugin := true,
    name := "sbt-houserules"
  )
