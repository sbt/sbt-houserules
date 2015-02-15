package sbt
package houserules

import sbt._
import Keys._
import com.typesafe.sbt.SbtScalariform.{ ScalariformKeys => sr, _ }

object FormatPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = baseSettings
  
  lazy val baseSettings: Seq[Setting[_]] = scalariformSettings ++ Seq(
    sr.preferences := formatPrefs
  )
  
  def formatPrefs = {
    import scalariform.formatter.preferences._
    FormattingPreferences().setPreference(AlignSingleLineCaseStatements, true)
  }
}
