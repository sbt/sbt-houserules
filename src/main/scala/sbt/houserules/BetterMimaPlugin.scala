package sbt
package houserules

import sbt._
import Keys._
import com.typesafe.tools.mima.core
import com.typesafe.tools.mima.plugin.MimaPlugin.mimaDefaultSettings
import com.typesafe.tools.mima.plugin.MimaKeys

object BetterMimaPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = baseSettings
  lazy val baseSettings: Seq[Setting[_]] = mimaDefaultSettings

  object autoImport {
    val failOnProblem: SettingKey[Boolean] = MimaKeys.failOnProblem

    val previousArtifact: SettingKey[Option[ModuleID]] = MimaKeys.previousArtifact
    val previousArtifacts: SettingKey[Set[ModuleID]]   = MimaKeys.previousArtifacts
    val previousClassfiles: TaskKey[Set[File]]         = MimaKeys.previousClassfiles
    val currentClassfiles: TaskKey[File]               = MimaKeys.currentClassfiles

    val findBinaryIssues: TaskKey[List[(File, List[core.Problem])]] = MimaKeys.findBinaryIssues
    val reportBinaryIssues: TaskKey[Unit]                           = MimaKeys.reportBinaryIssues

    val binaryIssueFilters: SettingKey[Seq[core.ProblemFilter]] = MimaKeys.binaryIssueFilters
  }
}
