package sbt
package houserules

import sbt._
import Keys._
import com.typesafe.sbt.SbtGit._
import com.typesafe.sbt.GitPlugin

object BetterGitVersionPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin && GitPlugin
  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = baseBuildSettings
  lazy val baseBuildSettings: Seq[Setting[_]] = versionWithGit
}
