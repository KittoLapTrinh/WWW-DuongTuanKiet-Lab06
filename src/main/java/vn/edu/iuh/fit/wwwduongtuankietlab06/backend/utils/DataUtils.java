package vn.edu.iuh.fit.wwwduongtuankietlab06.backend.utils;

import java.time.Instant;
import java.util.Date;

public class DataUtils {
    public static Date convertInstantToDate(Instant instant){
        return Date.from(instant);

    }
}
