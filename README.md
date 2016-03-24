# kohonen-som
Spark MlLib RDD implementation Kohonen SOM 

## Package a JAR containing your application
$ mvn package

## Use spark-submit to run your application
$ YOUR_SPARK_HOME/bin/spark-submit --class "org.megion.spark.mllib.kohonen.som.ExampleSOM" --master local[2] target/kohonen-som-1.0.jar

$ /home/ilya/frameworks/spark-1.6.0-bin-hadoop2.6/bin/spark-submit --class "org.megion.spark.mllib.kohonen.som.ExampleSOM" --master local[2] target/kohonen-som-1.0.jar
