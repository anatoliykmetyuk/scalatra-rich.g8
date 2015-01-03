import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._

object $name;format="Camel"$Build extends Build {
  val Organization = "$organization$"
  val Name = "$name$"
  val Version = "$version$"
  val ScalaVersion = "$scala_version$"
  val ScalatraVersion = "$scalatra_version$"

  lazy val project = Project (
    "$name;format="norm"$",
    file("."),
    settings = ScalatraPlugin.scalatraWithJRebel ++ scalateSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      libraryDependencies ++= Seq(
        // Scalatra
        "org.scalatra" %% "scalatra"         % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,

        // Testing
        "org.scalatest"           %% "scalatest"     % "2.2.3"   % "test",
        "org.seleniumhq.selenium" %  "selenium-java" % "2.44.0"  % "test",
        "org.mockito"             %  "mockito-all"   % "1.10.17" % "test",

        // Container
        "org.eclipse.jetty" % "jetty-webapp"      % "9.1.5.v20140505" % "container",
        "org.eclipse.jetty" % "jetty-plus"        % "9.1.5.v20140505" % "container",
        "javax.servlet"     % "javax.servlet-api" % "3.1.0",
        
        // Other
        "ch.qos.logback" % "logback-classic" % "1.1.2" % "runtime"
      ),
      scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
        Seq(
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "templates",
            Seq.empty,  /* default imports should be added here */
            Seq(
              Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
            ),  /* add extra bindings here */
            Some("templates")
          )
        )
      }
    )
  )
}
