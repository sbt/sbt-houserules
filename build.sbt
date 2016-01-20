lazy val commonSettings = Seq(
  organization := "org.scala-sbt",
  version := "0.2.2"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    sbtPlugin := true,
    name := "sbt-houserules",
    description := "sbt plugin for enforcing sbt house rules.",
    addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.5.1"),
    addSbtPlugin("com.typesafe.sbt" % "sbt-git" % "0.8.5"),
    addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0"),
    addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "0.7.0"),
    addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.1.8"),
    licenses := Seq("Apache v2" -> url("https://github.com/sbt/sbt-houserules/blob/master/LICENSE")),
    scmInfo := Some(ScmInfo(url("https://github.com/sbt/sbt-houserules"), "git@github.com:sbt/sbt-houserules.git")),
    bintrayOrganization := Some("sbt")
  )
