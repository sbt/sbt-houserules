package sbthouserules

import sbt._
import com.lucidchart.sbt.scalafmt.ScalafmtCorePlugin, ScalafmtCorePlugin.autoImport._

object StylePlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin && ScalafmtCorePlugin
  override def trigger = allRequirements

  override def buildSettings = Seq(
    scalafmtVersion := "1.2.0",
    scalafmtOnCompile := true,
    scalafmtOnCompile in Sbt := false,
  )
}
