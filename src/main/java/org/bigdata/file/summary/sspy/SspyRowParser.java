package org.bigdata.file.summary.sspy;

import org.bigdata.file.summary.core.DataSample;
import org.bigdata.file.summary.core.RowParser;

import java.util.List;

/**
 * Created by ilya on 3/28/16.
 */
public class SspyRowParser implements RowParser<SspyData> {
    @Override
    public SspyData parseRow(List<DataSample> samples, String rowStr) {
        String[] values = rowStr.split(" ");

        SspyData rowData = new SspyData();
        rowData.counter = Long.parseLong(values[0]);
        samples.add(new DataSample(rowData.counter, false));

        rowData.msg_type = values[1].charAt(0);
        rowData.stream_type = values[2].charAt(0);

        return rowData;
    }
}
