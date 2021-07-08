package org.daistudy.concurrent.beauty.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    public static String time() {
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(date);
    }
}
