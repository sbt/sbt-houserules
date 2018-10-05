package sbthouserules

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
    scalacOptions ++= "-Xfatal-warnings".ifScala(v => {
      sys.props.get("sbt.build.fatal") match {
        case Some(_) => java.lang.Boolean.getBoolean("sbt.build.fatal")
        case _       => v == 12
      }
    }).value.toList,
    scalacOptions ++= "-Yinline-warnings".ifScala211Minus.value.toList,
    scalacOptions ++= "-Yno-adapted-args".ifScala212Minus.value.toList,
    scalacOptions  += "-Ywarn-dead-code",
    scalacOptions  += "-Ywarn-numeric-widen",
    scalacOptions  += "-Ywarn-value-discard",
    scalacOptions ++= "-Ywarn-unused-import".ifScala(v => 11 <= v && v <= 12).value.toList
  ) ++ Seq(Compile, Test).flatMap(c =>
    scalacOptions in (c, console) --= Seq("-Ywarn-unused-import", "-Xlint")
  )

  private def scalaPartV = Def setting (CrossVersion partialVersion scalaVersion.value)

  private implicit final class AnyWithIfScala[A](val __x: A) {
    def ifScala(p: Long => Boolean) = Def setting (scalaPartV.value collect { case (2, y) if p(y) => __x })
    def ifScalaLte(v: Long)         = ifScala(_ <= v)
    def ifScalaGte(v: Long)         = ifScala(_ >= v)
    def ifScala211Minus             = ifScalaLte(11)
    def ifScala211Plus              = ifScalaGte(11)
    def ifScala212Minus             = ifScalaLte(12)
  }
}
