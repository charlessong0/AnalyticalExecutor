import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object WordCountApp {
  def main(args:Array[String]) : Unit = {
    val conf = new SparkConf().setAppName("WordCountApp").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val tf = sc.textFile(args(0))
    val splits: RDD[Int] = tf.flatMap(line => line.split(" ")).map(word =>(1))
    //val counts = splits.reduce((x,y)=>x+y)
    println(splits.collect().toList + "=== this is the word count!")
    println("123")
  }
}
