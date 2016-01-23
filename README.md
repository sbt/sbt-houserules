sbt-houserules
==============

sbt-houserules is a house rules plugin for sbt modules.

### latest

```scala
addSbtPlugin("org.scala-sbt" % "sbt-houserules" % "0.2.1")
```

### what each build needs to supply

```
import com.typesafe.tools.mima.core._, ProblemFilters._

inThisBuild(Seq(
  git.baseVersion := "0.1.0",
  bintrayPackage := "io",
  scmInfo := Some(ScmInfo(url("https://github.com/sbt/io"), "git@github.com:sbt/io.git")),
  description := "IO module for sbt",
  previousArtifact := Some(organization.value % moduleName.value % "1.0.0"),
  binaryIssueFilters ++= Seq(
  )
))
```
