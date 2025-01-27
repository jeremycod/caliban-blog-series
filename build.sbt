name := "caliban-blog-series"

version := "0.1"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "com.github.ghostdogpr"         %% "caliban"                       % "2.0.1",
  "com.github.ghostdogpr"         %% "caliban-http4s"                % "2.0.1",
  "com.github.ghostdogpr"         %% "caliban-client"                % "2.0.1",
  "org.http4s"                    %% "http4s-blaze-server"           % "0.23.12",
  "com.softwaremill.sttp.client3" %% "async-http-client-backend-zio" % "3.7.2"
)

enablePlugins(CalibanPlugin)
