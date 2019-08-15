val buildName = "finagle-websocket"

name := buildName

lazy val buildSettings = Seq(
  organization := "com.novolabs",
  scalaVersion := "2.12.9",
  version      := "2.0.0-SNAPSHOT"
)

lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-unchecked",
  "-language:existentials",
  "-Xfatal-warnings",
  "-language:implicitConversions",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-value-discard",
  "-Ywarn-unused-import",
  "-Ypartial-unification",
  "-Xfuture"
)

lazy val versions = new {
  val finagle   = "19.8.0"
  val scalaTest = "3.0.1"
}

lazy val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % versions.scalaTest 
)

libraryDependencies ++= {
  Seq(
  //"com.twitter" % "finagle-core_2.12" % "19.8.0"
    "com.twitter"   %  "finagle-core_2.12"      %   versions.finagle,
    "com.twitter"   %  "finagle-netty4_2.12"    %   versions.finagle
  )
}

resolvers ++= Seq(
  "Twitter Maven repo" at "http://maven.twttr.com/",
  Resolver.mavenLocal
)

lazy val vox = (project in file("."))
  .configs(IntegrationTest)
  .settings(
    name := buildName,
    libraryDependencies ++= testDependencies,
    scalacOptions ++= compilerOptions,
    //Compile / console / scalacOptions ++= compilerOptions,
    Defaults.itSettings
)
