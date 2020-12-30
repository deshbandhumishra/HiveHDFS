name := "hiveClient"

version := "0.1"

scalaVersion := "2.13.2"

val hadoopVersion = "3.1.0"

//noinspection Annotator,Annotator,Annotator
libraryDependencies += "org.apache.hadoop" % "hadoop-common" % hadoopVersion
libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion
