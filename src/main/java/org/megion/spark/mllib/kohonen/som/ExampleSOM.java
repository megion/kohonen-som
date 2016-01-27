package org.megion.spark.mllib.kohonen.som;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

public class ExampleSOM {

    public static void main(String[] args) {
        String logFile = "/home/ilya/eclipses/spark-1.6.0-bin-hadoop2.6/README.md"; // Should be some file on your system
        SparkConf conf = new SparkConf().setAppName("Simple Application");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(logFile).cache();

        long numAs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("a"); }
        }).count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("b"); }
        }).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        class GetLength implements Function<String, Integer> {
            public Integer call(String s) {
                return s.length();
            }
        }
        class Sum implements Function2<Integer, Integer, Integer> {
            public Integer call(Integer a, Integer b) {
                System.out.println("Reduce a + b: " + a + " + " + b);
                return a + b;
            }
        }

        JavaRDD<String> lines = sc.textFile("/home/ilya/eclipses/spark-1.6.0-bin-hadoop2.6/README.md");
        JavaRDD<Integer> lineLengths = lines.map(new GetLength());
        int totalLength = lineLengths.reduce(new Sum());
        System.out.println("totalLength: " + totalLength);
    }
}
