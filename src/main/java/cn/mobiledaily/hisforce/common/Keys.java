package cn.mobiledaily.hisforce.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Johnson on 2015/11/24.
 */
public final class Keys {
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyyMMdd");

    public static String doctorRegistrationQueue(Long doctorId, Date date) {
        return String.format("doctor:%d:d:%s", doctorId, FORMATTER.format(date));
    }
}
