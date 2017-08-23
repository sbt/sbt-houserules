lazy val commonSettings = Seq(
  organization := "org.scala-sbt",
  version := "0.3.5-SNAPSHOT"
)

sbtVersion in Global := "1.0.0" // must be Global, otherwise ^^ won't change anything
crossSbtVersions := List("0.13.13", "1.0.0")

lazy val root = (project in file(".")).
  settings(
    commonSettings,
    sbtPlugin := true,
    name := "sbt-houserules",
    description := "sbt plugin for enforcing sbt house rules.",

    addSbtPlugin("com.lucidchart"    % "sbt-scalafmt"    % "1.10"),
    addSbtPlugin("com.typesafe.sbt"  % "sbt-git"         % "0.9.3"),
    addSbtPlugin("org.foundweekends" % "sbt-bintray"     % "0.5.1"),
    addSbtPlugin("com.typesafe"      % "sbt-mima-plugin" % "0.1.18"),
    addSbtPlugin("com.jsuereth"      % "sbt-pgp"         % "1.1.0-M1"),

    licenses := Seq("Apache v2" -> url("https://github.com/sbt/sbt-houserules/blob/master/LICENSE")),
    scmInfo := Some(ScmInfo(url("https://github.com/sbt/sbt-houserules"), "git@github.com:sbt/sbt-houserules.git")),
    bintrayOrganization := Some("sbt"),
    bintrayRepository := "sbt-plugin-releases"
  )

// WORKAROUND https://github.com/sbt/sbt/issues/3393
def addSbtPlugin(m: ModuleID) =
  libraryDependencies += Defaults.sbtPluginExtra(
    m,
    (sbtBinaryVersion in pluginCrossBuild).value,
    (scalaBinaryVersion in update).value
  )
