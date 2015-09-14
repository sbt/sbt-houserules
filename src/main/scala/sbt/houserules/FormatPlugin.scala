package sbt
package houserules

import sbt._
import Keys._
import com.typesafe.sbt.SbtScalariform
import SbtScalariform.{ ScalariformKeys => sr, _ }

object FormatPlugin extends AutoPlugin {
  override def requires = plugins.JvmPlugin && SbtScalariform
  override def trigger = allRequirements

  override def projectSettings: Seq[Def.Setting[_]] = baseSettings

  lazy val baseSettings: Seq[Setting[_]] = Seq(
    sr.preferences := formatPrefs
  )

  def formatPrefs = {
    import scalariform.formatter.preferences._
    FormattingPreferences().
      setPreference(SpacesAroundMultiImports, true). // this was changed in 0.1.7 scalariform, setting this to preserve default.
      // setPreference(DoubleIndentClassDeclaration, true).
      setPreference(AlignSingleLineCaseStatements, true)
  }
}
