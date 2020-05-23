package cn.itcast.Utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GuoQingchun
 * @date 2020/5/20  - 16:20
 */
public class stringToDataConverte implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (null == s){
            throw new RuntimeException("传入带转换的数据为空!");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
           return dateFormat.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("传入带转换的数据转换异常!");
        }

    }
}
