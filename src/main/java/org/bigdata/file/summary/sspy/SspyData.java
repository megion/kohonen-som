package org.bigdata.file.summary.sspy;

/**
 * Created by ilya on 3/28/16.
 */
public class SspyData {
    public long counter; // Счетчик принимаемых пакетов, считается индивидуально по каждому STB.
    // Позволяет обнаружить пропадание пакетов статистики.
    public char msg_type; // Тип события
    public char stream_type; // Тип медиапотока
}
