package sbt
package houserules

import sbt._
import Keys._

object HouseRulesPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = baseBuildSettings
  override def projectSettings: Seq[Def.Setting[_]] = baseSettings

  lazy val baseBuildSettings: Seq[Def.Setting[_]] = Seq(
    organization := "org.scala-sbt"
  )

  lazy val baseSettings: Seq[Def.Setting[_]] = Seq(
    scalacOptions ++= Seq("-encoding", "utf8"),
    scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked", "-Xlint"),
    scalacOptions  += "-language:higherKinds",
    scalacOptions  += "-language:implicitConversions",
    scalacOptions  += "-Xfuture",
    scalacOptions  ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
      case Some((2, v)) if v <= 11 =>
        "-Yinline-warnings"
    }.toSeq,
    scalacOptions  += "-Yno-adapted-args",
    scalacOptions  += "-Ywarn-dead-code",
    scalacOptions  += "-Ywarn-numeric-widen",
    scalacOptions  += "-Ywarn-value-discard",
    scalacOptions  += "-Ywarn-unused",
    scalacOptions  += "-Ywarn-unused-import"
  )
}
