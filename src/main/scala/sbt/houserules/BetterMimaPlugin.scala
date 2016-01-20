package sbt
package houserules

import sbt._
import Keys._
import com.typesafe.tools.mima.plugin.MimaPlugin.mimaDefaultSettings

object BetterMimaPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = baseBuildSettings
  lazy val baseBuildSettings: Seq[Setting[_]] = mimaDefaultSettings
}
