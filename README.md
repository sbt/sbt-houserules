sbt-houserules
==============

sbt-houserules is a house rules plugin for sbt modules.

### setup

![Bintray version](https://img.shields.io/bintray/v/sbt/sbt-plugin-releases/sbt-houserules.svg)

```scala
addSbtPlugin("org.scala-sbt" % "sbt-houserules" % "x.y.z")
```

### what each build needs to supply

```
import com.typesafe.tools.mima.core._, ProblemFilters._

inThisBuild(Seq(
  git.baseVersion := "0.1.0",
  bintrayPackage := "io",
  scmInfo := Some(ScmInfo(url("https://github.com/sbt/io"), "git@github.com:sbt/io.git")),
  description := "IO module for sbt",
  previousArtifact := Some(organization.value %% moduleName.value % "1.0.0"),
  binaryIssueFilters ++= Seq(
  )
))
```
