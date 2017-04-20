name := """play-quill-async-postgres-example"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
    jdbc,
    cache,
    ws,
    evolutions,
    "org.postgresql" % "postgresql" % "9.4.1208",
    "io.getquill" %% "quill-async-postgres" % "1.1.0"
)

