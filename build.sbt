lazy val commonSettings = Seq(
  organization := "org.scala-sbt",
  version := "0.3.3-SNAPSHOT"
)

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    sbtPlugin := true,
    name := "sbt-houserules",
    description := "sbt plugin for enforcing sbt house rules.",

    // addSbtPlugin("com.lucidchart"    % "sbt-scalafmt"         % "0.3"),

    addSbtPlugin("com.typesafe.sbt" % "sbt-git"               % "0.9.3"),
    addSbtPlugin("org.foundweekends" % "sbt-bintray"          % "0.5.1"),
    // addSbtPlugin("org.scalastyle"   % "scalastyle-sbt-plugin" % "0.8.0"),
    // addSbtPlugin("com.typesafe"     % "sbt-mima-plugin"       % "0.1.11"),
    addSbtPlugin("com.jsuereth"     % "sbt-pgp"               % "1.1.0-M1"),

    licenses := Seq("Apache v2" -> url("https://github.com/sbt/sbt-houserules/blob/master/LICENSE")),
    scmInfo := Some(ScmInfo(url("https://github.com/sbt/sbt-houserules"), "git@github.com:sbt/sbt-houserules.git")),
    bintrayOrganization := Some("sbt"),
    bintrayRepository := "sbt-plugin-releases"
  )
