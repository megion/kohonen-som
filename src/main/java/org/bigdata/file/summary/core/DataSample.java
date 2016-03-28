package org.bigdata.file.summary.core;

/**
 * Created by ilya on 3/28/16.
 */
public class DataSample {
    public double value;
    public boolean skipped;

    public DataSample() {
    }

    public DataSample(double value, boolean skipped) {
        this.value = value;
        this.skipped = skipped;
    }
}
