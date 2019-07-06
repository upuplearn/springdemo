package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) throws IOException {
		//SpringApplication.run(DemoApplication.class, args);
		String property = System.getProperty("user.dir");
		property+= File.separator;
		System.out.println(property);
		Map map6=new HashMap();
		map6.put("a6","b6");
		/*Map testmethod = testmethod(new HashMap<String, Object>() {
			{
				put("liu", "na");
			}
		});*/
		Map testmethod = testmethod(new HashMap<String, Object>(map6) {

		});
		System.out.println(testmethod);
	}
	public static Map testmethod(Map map3) throws IOException {
		Map map=new HashMap();
		Map map2=new HashMap();
		map.put("a","b");
		map2=new HashMap<String,Object>(map);
		System.out.println(map2);
		int s =0x3f;
		System.out.println(s);
		String property = System.mapLibraryName("user.dir");
		String property1 = System.getProperty("user.dir")+"/lib/HWPuSDK";
		String file =new File("static/file/apache-tomcat-7.0.94.zip").getCanonicalPath();
		System.out.println(file+"++");
		try {
			long	time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2019-1-26 08:00:00").getTime();
		System.out.println(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(property1);
		return map3;
	}

}
