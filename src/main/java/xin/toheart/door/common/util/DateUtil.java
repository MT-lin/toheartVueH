package xin.toheart.door.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    /**
     * 将日期转换成指定格式的字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String dataToString(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
