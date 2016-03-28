package org.bigdata.file.summary.core;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilya on 3/28/16.
 */
public class SummaryCollector {

    /**
     * Reduce step
     */
    static class GetSamples<Row> implements Function<String, List<DataSample>> {

        private RowParser<Row> parser;

        public GetSamples(RowParser<Row> parser) {
            this.parser = parser;
        }

        public List<DataSample> call(String rowStr) {
            int dim = 1;
            ColSummary colSummary = new ColSummary();
            List<DataSample> samples = new ArrayList<DataSample>(dim);
            parser.parseRow(samples, rowStr);

//            for (DataSample sample: samples) {
//                if(!sample.skipped) {
//                    colSummary.count++;
//                    colSummary.sum += sample.value;
//                    if (sample.value > colSummary.max) {
//                        colSummary.max = sample.value;
//                    }
//                    if (sample.value < colSummary.min) {
//                        colSummary.min = sample.value;
//                    }
//                }
//            }
            // инициализация colMedians нулями, если 20 колонок нам нужны то 20 нулей
            // разбор строки на колонки List<String> cols
            // если данные допустимы в колонке (cols[i]!='X' или cols[i]!='-1' тут нужно учесть
            // что для каждой колонки допустимые значения разные) то colMedians.medians[i]+=cols[i], colMedians.counts[i]++

//            List<ColSummary> cols = new ArrayList<ColSummary>(dim);
            return samples;
        }
    }

    static class CalculateSummary implements Function2<List<DataSample>, List<ColSummary>, List<ColSummary>> {
        public List<ColSummary> call(List<DataSample> samples, List<ColSummary> colSummaries) {
            List<ColSummary> result = new ArrayList<ColSummary>();
            System.out.println("Reduce a + b: " + a + " + " + b);
            return a + b;
        }
    }

    void collect(JavaRDD<String> lines, RowParser parser) {


    }
}
