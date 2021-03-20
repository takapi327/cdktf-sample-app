name         := """cdktf-sample-app"""
organization := "com.example"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

/**
 * Setting for Docker Image
 */
enablePlugins(DockerPlugin)
maintainer         in Docker := "happyhappy001@outlook.jp"
dockerBaseImage              := "amazoncorretto:8"
dockerExposedPorts in Docker := Seq(9000, 9000)
daemonUser         in Docker := "daemon"

/** setting AWS Ecr */
import com.amazonaws.regions.{Region, Regions}

enablePlugins(EcrPlugin)

region           in Ecr := Region.getRegion(Regions.AP_NORTHEAST_1)
repositoryName   in Ecr := "project/sample-ecr"
repositoryTags   in Ecr := Seq(version.value, "latest")
localDockerImage in Ecr := (packageName in Docker).value + ":" + (version in Docker).value

/** Setting sbt-release */
import ReleaseTransformations._

releaseVersionBump := sbtrelease.Version.Bump.Bugfix

releaseProcess := Seq[ReleaseStep](
  ReleaseStep(state => Project.extract(state).runTask(login in Ecr, state)._1),
  inquireVersions,
  runClean,
  setReleaseVersion,
  ReleaseStep(state => Project.extract(state).runTask(publishLocal in Docker, state)._1),
  ReleaseStep(state => Project.extract(state).runTask(push in Ecr, state)._1),
  commitReleaseVersion,
  tagRelease,
  setNextVersion,
  commitNextVersion,
  pushChanges
)
