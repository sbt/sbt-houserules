lazy val commonSettings = Seq(
  organization := "org.scala-sbt",
  version := "0.2.0-SNAPSHOT"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings ++
    addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.5.1") ++
    addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.8.5") ++
    addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")
  : _*).
  settings(
    sbtPlugin := true,
    name := "sbt-houserules",
    description := "sbt plugin for enforcing sbt house rules.",
    licenses := Seq("Apache v2" -> url("https://github.com/sbt/sbt-houserules/blob/master/LICENSE")),
    publishMavenStyle := false,
    publishTo := {
      if (isSnapshot.value) Some(Resolver.sbtPluginRepo("snapshots"))
      else Some(Resolver.sbtPluginRepo("releases"))
    },
    credentials += Credentials(Path.userHome / ".ivy2" / ".sbtcredentials")
  )
