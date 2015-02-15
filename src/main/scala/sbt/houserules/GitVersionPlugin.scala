package sbt
package houserules

import sbt._
import Keys._
import com.typesafe.sbt.SbtGit._

object GitVersionPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[_]] = baseBuildSettings
  
  lazy val baseBuildSettings: Seq[Setting[_]] = versionWithGit ++ Seq(
    isSnapshot := true,
    version := {
      val old = version.value
      if (isSnapshot.value) old
      else git.baseVersion.value
    }
  )
}
