
import org.apache.hadoop.fs.Path
import java.io.PrintWriter

/*  @author ${user.name} */
object Main extends App with Config {
      println( "Trying to write to HDFS..." )
    val output = fs.create(new Path("/user/root/Mr_shah"))
    val writer = new PrintWriter(output)
    try {
      writer.write("this is a test")
      writer.write("\n") }
    finally {
      writer.close()
    }
    print("Done!")
}