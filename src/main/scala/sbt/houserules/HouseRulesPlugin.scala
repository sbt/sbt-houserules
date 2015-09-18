package sbt
package houserules

import sbt._
import Keys._

object HouseRulesPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = baseBuildSettings

  val baseBuildSettings: Seq[Def.Setting[_]] = Seq(
    organization := "org.scala-sbt"
  )
}
