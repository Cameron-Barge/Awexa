name := """Awexa"""
organization := "Awexa"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)



scalaVersion := "2.12.2"

libraryDependencies += guice
libraryDependencies += "com.google.firebase" % "firebase-admin" % "5.4.0"

