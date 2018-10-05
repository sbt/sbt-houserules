ThisBuild / version := "0.3.10-SNAPSHOT"

Global / sbtVersion := "1.1.6" // must be Global, otherwise ^^ won't change anything

lazy val root = (project in file("."))
  .settings(
    sbtPlugin := true,
    name := "sbt-houserules",

    addSbtPlugin("com.typesafe.sbt"  % "sbt-git"         % "1.0.0"),
    addSbtPlugin("org.foundweekends" % "sbt-bintray"     % "0.5.4"),
    addSbtPlugin("com.typesafe"      % "sbt-mima-plugin" % "0.3.0"),
    addSbtPlugin("com.jsuereth"      % "sbt-pgp"         % "1.1.1"),

    bintrayOrganization := Some("sbt"),
    bintrayRepository := "sbt-plugin-releases",
    crossSbtVersions := List("0.13.13", "1.1.6"),
  )
