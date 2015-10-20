name := "EventSourcer"

version := "0.1"

val akkaVersion = "2.4.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
       "com.typesafe.akka" % "akka-persistence_2.11" % "2.4.0",
       //"com.typesafe.akka" %% "akka-persistence-query-experimental" % "2.4.0",
       "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
       "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion % Test,
       "ch.qos.logback" % "logback-classic" % "1.0.13",
       "org.iq80.leveldb"  % "leveldb" % "0.7",
       "org.fusesource.leveldbjni" %  "leveldbjni-all"   % "1.8",
       "org.scalatest" %% "scalatest" % "2.2.4" % Test
)

libraryDependencies += "javax.inject" % "javax.inject" % "1"
