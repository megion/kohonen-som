package org.bigdata.file.summary.core;

/**
 * Created by ilya on 3/28/16.
 */
public class ColSummary {
    public  double min; // минимальное допустимое значение
    public double max; // максимальное (допустимое) значение в колонке
    public double sum; // сумма допустимых значений в колонке
    public double average; // среднее значение sum/count
    public double scaledAverage; // нормализованное среднее значение
    public long count; // число допустимых значенией в колонке (не все значения являются допустимыми)

    ColSummary() {
        double minVal = -Double.MAX_VALUE;
        double maxVal = Double.MAX_VALUE;
        // initialization
        min = maxVal;
        max = minVal;
        sum = 0;
        average = 0;
        scaledAverage = 0;
        count = 0;
    }

    public double getAverage(boolean isScale) {
        return isScale ? scaledAverage : average;
    }

    public boolean isSkip() {
        return (count==0) || (max == min);
    }
}
