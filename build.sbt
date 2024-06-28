ThisBuild / version := "0.0.1"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "zowie-task",
    idePackagePrefix := Some("pl.emmajk"),
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.18" % "test")
  )
