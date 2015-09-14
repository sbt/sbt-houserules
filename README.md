sbt-houserules
==============

sbt-houserules is a house rules plugin for sbt modules.

### what each build needs to supply

```
inThisBuild(Seq(
  git.baseVersion := "0.1.0",
  bintrayPackage := "io",
  scmInfo := Some(ScmInfo(url("https://github.com/sbt/io"), "git@github.com:sbt/io.git")),
  description := "IO module for sbt"
))
```
