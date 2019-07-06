package com.example.demo;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author xyys
 * @version 1.0
 * @description com.example.demo
 * @date 2019/6/24 0024
 */
public class I18n {
    public static void main(String[] args){
        //定义占位符参数
      /* Object[] params={"Jack",new GregorianCalendar().getTime(),238.2E5};

       String pattern1="{0}，您好！您的账户在 {1} 收到 {2} 元";
       System.out.println(MessageFormat.format(pattern1,params));//使用默认本地化对象

       String pattern2="{0}，hello！Your account have received {2,number,currency} at {1," +
               "time,short} on " +
               "{1,date,long}";
       System.out.println(new MessageFormat(pattern2, Locale.US).format(params));//使用指定的本地化对象
  */
        final String baseName = "i18n/content";
        final String key = "message";
        System.out.println("中国："+ ResourceBundle.getBundle(baseName,
                Locale.CHINA).getString(key));
        System.out.println("美国："+ResourceBundle.getBundle(baseName,
                Locale.US).getString(key));

        Object[] params = {"Jack", new GregorianCalendar().getTime()};
        ResourceBundle rb1 = ResourceBundle.getBundle("i18n/content", Locale.CHINA);
        System.out.println("中国：" + new MessageFormat(rb1.getString(key), Locale
                .CHINA)
                .format(params));
        ResourceBundle rb2 = ResourceBundle.getBundle("i18n/content", Locale.US);
        System.out.println("美国：" + new MessageFormat(rb2.getString(key), Locale
                .US)
                .format(params));
    }
}
