package org.megion.spark.mllib.kohonen.som;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.mllib.clustering.KMeans;
import org.apache.spark.mllib.clustering.KMeansModel;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;

import java.util.ArrayList;
import java.util.List;

public class ExampleSOM {

    public static void main(String[] args) {
        String contentFile = "/home/ilya/Documents/ml/sspy/content_data_100.cod"; // Should be some file on your system
        SparkConf conf = new SparkConf().setAppName("K-means Example");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rowsData = sc.textFile(contentFile);

        JavaRDD<Vector> parsedData = rowsData.map(
                new Function<String, Vector>() {
                    public Vector call(String s) {
                        String[] sarray = s.split(" ");
                        double[] values = new double[1];

                        values[0] = Double.parseDouble(sarray[0]);
//                        values[1] = Double.NaN;
                        return Vectors.dense(values);
                    }
                }
        );

        // Cluster the data into two classes using KMeans
        int numClusters = 2;
        int numIterations = 20;
        KMeansModel clusters = KMeans.train(parsedData.rdd(), numClusters, numIterations);

        // Evaluate clustering by computing Within Set Sum of Squared Errors
        double WSSSE = clusters.computeCost(parsedData.rdd());
        System.out.println("Within Set Sum of Squared Errors = " + WSSSE);


//        long numAs = logData.filter(new Function<String, Boolean>() {
//            public Boolean call(String s) { return s.contains("a"); }
//        }).count();
//
//        long numBs = logData.filter(new Function<String, Boolean>() {
//            public Boolean call(String s) { return s.contains("b"); }
//        }).count();
//
//        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);


//        class ColMedian {
//            List<Double> medians;
//            List<Long> counts;
//        }
        //

//        class CalculateMedian implements Function<String, ColMedian> {
//            public ColMedian call(String s) {
//                ColMedian colMedians = new ColMedian();
//                // инициализация colMedians нулями, если 20 колонок нам нужны то 20 нулей
//                // разбор строки на колонки List<String> cols
//                // если данные допустимы в колонке (cols[i]!='X' или cols[i]!='-1' тут нужно учесть
//                // что для каждой колонки допустимые значения разные) то colMedians.medians[i]+=cols[i], colMedians.counts[i]++
//                return colMedians;
//            }
//        }

//        JavaRDD<Integer> lineLengths = lines.map(new CalculateMedian());
//        ColMedian med = lineLengths.reduce(new ReduceMedian());

//        class GetLength implements Function<String, Integer> {
//            public Integer call(String s) {
//                return s.length();
//            }
//        }
//        class Sum implements Function2<Integer, Integer, Integer> {
//            public Integer call(Integer a, Integer b) {
//                System.out.println("Reduce a + b: " + a + " + " + b);
//                return a + b;
//            }
//        }
//
//        JavaRDD<String> lines = sc.textFile(contentFile);
//        JavaRDD<Integer> lineLengths = lines.map(new GetLength());
//        int totalLength = lineLengths.reduce(new Sum());
//        System.out.println("totalLength: " + totalLength);

        // получение треугольной квадратной матрицы ковариации
//        List<List<Double>> squareMatrix;
//        int colSize = 20;
//        while (dataReader->readNext(inRow)) { //цикл по RDD
//            for (int i = 0; i < colSize; ++i) {
//                if (inDataRow[i] имеет не допустимое значение) {
//                    continue;
//                }
//                for (int j = i; j < colSize; ++j) {
//                    if (inDataRow[j] допустимое значение) {
//                        squareMatrix[i, j] = squareMatrix[i, j] +
//                                (inDataRow[i] - colMedians[i]) *
//                                        (inDataRow[j] - colMedians[j]);
//                    }
//                }
//            }
//        }
    }
}
