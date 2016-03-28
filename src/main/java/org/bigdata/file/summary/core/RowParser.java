package org.bigdata.file.summary.core;

import java.util.List;

/**
 * Created by ilya on 3/28/16.
 */

public interface RowParser<Row> {

    Row parseRow(List<DataSample> samples, String rowStr);
}
