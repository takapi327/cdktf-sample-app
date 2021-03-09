addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.7")
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.11.0")

/**
 * @see: https://github.com/sbt/sbt-native-packager
 * Install For Create Docker Image
 */
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.7.6")

/**
 * @see: https://github.com/sjednac/sbt-ecr
 * Install For Create Ecr
 */
addSbtPlugin("com.mintbeans" % "sbt-ecr" % "0.15.0")
