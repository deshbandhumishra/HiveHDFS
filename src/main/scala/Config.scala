
import java.sql.{Connection, DriverManager, Statement}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem

trait Config {
  System.setProperty("hadoop.home.dir", "/")
  val conf = new Configuration()
  //Set dynamic value by using this --> conf.set("fs.defaultFS", "hdfs://quickstart.cloudera:8020")
  conf.set("fs.defaultFS", "hdfs://172.17.0.2:8020")
  val fs: FileSystem = FileSystem.get(conf)

  val driverName: String = "org.apache.hive.jdbc.HiveDriver"
  Class.forName(driverName)
  val connection: Connection = DriverManager.getConnection("jdbc:hive2://172.17.0.2:10000/default;user=cloudera;password=cloudera")
  val stmt: Statement = connection.createStatement()
  stmt.execute("DROP TABLE IF EXISTS default.ext_trips")
  stmt.execute("CREATE TABLE default.ext_trips (route_id Int,  service_id String, trip_id String," +
    "  trip_headsign String,direction_id String," +
    " shape_id String, wheelchair_accessible Int," +
    "  note_fr String, note_en String)" +
    " ROW FORMAT DELIMITED" +
    " FIELDS TERMINATED BY ',' " +
    "STORED AS TEXTFILE" )
  println("trips table created ")

}

