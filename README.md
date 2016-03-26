# kohonen-som
Spark MlLib RDD implementation Kohonen SOM 

## Package a JAR containing your application
$ mvn package

## Use spark-submit to run your application
$ YOUR_SPARK_HOME/bin/spark-submit --class "org.megion.spark.mllib.kohonen.som.ExampleSOM" --master local[2] target/kohonen-som-1.0.jar

$ /home/ilya/frameworks/spark-1.6.0-bin-hadoop2.6/bin/spark-submit --class "org.megion.spark.mllib.kohonen.som.ExampleSOM" --master local[2] target/kohonen-som-1.0.jar

## YARN
$ ./bin/spark-submit --class path.to.your.Class --master yarn --deploy-mode cluster [options] <app jar> [app options]

------------------------------------------------------------------
# 1. User specific environment and startup programs

GRADLE_HOME=$HOME/gradle-1.10

export GRADLE_HOME

JAVA_HOME=/usr/lib/jvm/jdk1.7.0_80

export JAVA_HOME

HIVE_HOME=/home/ilya/frameworks/apache-hive-1.2.1-bin
export HIVE_HOME

HADOOP_HOME=/home/ilya/frameworks/hadoop-2.6.1
export HADOOP_HOME

HADOOP_USER_CLASSPATH_FIRST=true
export HADOOP_USER_CLASSPATH_FIRST

SPARK_HOME=/home/ilya/frameworks/spark-1.6.0-bin-hadoop2.6
export SPARK_HOME

PATH=$PATH:$HOME/.local/bin:$HOME/bin:$GRADLE_HOME/bin:$HIVE_HOME/bin

export PATH

# 2. start dfs and yarn
sbin/start-dfs.sh
$HADOOP_HOME/sbin/start-yarn.sh

https://cwiki.apache.org/confluence/display/Hive/Hive+on+Spark%3A+Getting+Started
https://cwiki.apache.org/confluence/display/Hive/GettingStarted#GettingStarted-MetadataStore
http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-common/SingleCluster.html

mvn package && /home/ilya/frameworks/spark-1.6.0-bin-hadoop2.6/bin/spark-submit --class "org.megion.spark.mllib.kohonen.som.ExampleSOM" --master spark://izadorozhny4.artgroup.local:7077 --executor-memory 512M --num-executors 1 target/kohonen-som-1.0.jar

spark-env.sh
-------------------
SPARK_EXECUTOR_INSTANCES=1
SPARK_EXECUTOR_MEMORY=2G
SPARK_EXECUTOR_CORES=1

hive-site.xml
----------------------------------
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<?xml-stylesheet type="text/xsl" href="configuration.xsl"?>
<configuration>
  <property>
    <name>spark.master</name>
    <value>spark://izadorozhny4.artgroup.local:7077</value>
  </property>
  <property>
    <name>spark.serializer</name>
    <value>org.apache.spark.serializer.KryoSerializer</value>
  </property>
</configuration>

spark start
---------------
sbin/start-all.sh