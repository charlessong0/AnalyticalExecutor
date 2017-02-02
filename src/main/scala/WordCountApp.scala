import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by Giri R Varatharajan on 9/8/2015.
  */
object WordCountApp {
  def main(args:Array[String]) : Unit = {
    System.setProperty("hadoop.home.dir", "D:\\hadoop\\hadoop-common-2.2.0-bin-master\\")
    val conf = new SparkConf().setAppName("WordCountApp").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val tf = sc.textFile(args(0))
    val splits = tf.flatMap(line => line.split(" ")).map(word =>(word,1))
    val counts = splits.reduceByKey((x,y)=>x+y)
    splits.saveAsTextFile(args(1))
    counts.saveAsTextFile(args(2))
  }
}
