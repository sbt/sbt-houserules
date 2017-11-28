lazy val commonSettings = Seq(
  organization := "org.scala-sbt",
  version := "0.3.5-SNAPSHOT"
)

sbtVersion in Global := "1.0.4" // must be Global, otherwise ^^ won't change anything
crossSbtVersions := List("0.13.13", "1.0.4")

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    sbtPlugin := true,
    name := "sbt-houserules",
    description := "sbt plugin for enforcing sbt house rules.",

    addSbtPlugin("com.lucidchart"    % "sbt-scalafmt"      % "1.12"),
    addSbtPlugin("com.typesafe.sbt"  % "sbt-git"           % "0.9.3"),
    addSbtPlugin("ch.epfl.scala"     % "sbt-release-early" % "2.0.0"),
    addSbtPlugin("com.typesafe"      % "sbt-mima-plugin"   % "0.1.18"),

    licenses := Seq("Apache v2" -> url("https://github.com/sbt/sbt-houserules/blob/master/LICENSE")),
    scmInfo := Some(ScmInfo(url("https://github.com/sbt/sbt-houserules"), "git@github.com:sbt/sbt-houserules.git")),
    bintrayOrganization := Some("sbt"),
    bintrayRepository := "sbt-plugin-releases"
  )
