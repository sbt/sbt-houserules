// package sbthouserules

// import sbt._
// import Keys._
// import Path._
// import org.scalastyle.sbt.ScalastylePlugin._

// object StylePlugin extends AutoPlugin {
//   override def requires = plugins.JvmPlugin
//   override def trigger = allRequirements

//   override def projectSettings: Seq[Def.Setting[_]] = baseSettings

//   lazy val baseSettings: Seq[Setting[_]] = Seq(
//     scalastyleConfig := { new File((baseDirectory in LocalRootProject).value, "scalastyle-config.xml") }
//   )
// }
