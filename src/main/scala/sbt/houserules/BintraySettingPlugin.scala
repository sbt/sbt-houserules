package sbthouserules

import sbt._
import Keys._
import bintray.BintrayPlugin
import bintray.BintrayPlugin.autoImport._

object BintraySettingPlugin extends AutoPlugin {
  override def requires = plugins.IvyPlugin && BintrayPlugin
  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = baseBuildSettings
  override def projectSettings: Seq[Def.Setting[_]] = baseSettings

  lazy val baseBuildSettings: Seq[Setting[_]] = Seq(
    licenses := List("BSD New" -> url("https://github.com/sbt/sbt/blob/0.13/LICENSE")),
    developers := List(
      Developer("harrah", "Mark Harrah", "@harrah", url("https://github.com/harrah")),
      Developer("eed3si9n", "Eugene Yokota", "@eed3si9n", url("https://github.com/eed3si9n")),
      Developer("jsuereth", "Josh Suereth", "@jsuereth", url("https://github.com/jsuereth")),
      Developer("dwijnand", "Dale Wijnand", "@dwijnand", url("https://github.com/dwijnand")),
      Developer("gkossakowski", "Grzegorz Kossakowski", "@gkossakowski", url("https://github.com/gkossakowski")),
      Developer("Duhemm", "Martin Duhem", "@Duhemm", url("https://github.com/Duhemm"))
    ),
    bintrayReleaseOnPublish := false,
    bintrayOrganization := Some("sbt"),
    bintrayRepository := "maven-releases"
  )

  lazy val baseSettings: Seq[Setting[_]] = Seq(
    bintrayPackage := (bintrayPackage in ThisBuild).value,
    bintrayRepository := (bintrayRepository in ThisBuild).value
  )
}
