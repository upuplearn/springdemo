package com.example.demo;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.UUID;

import java.io.File;
import java.io.FileInputStream;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_512;


/**
 * @author xyys
 * @version 1.0
 * @description com.example.demo
 * @date 2019/6/6 0006
 */
@Controller
public class Md5Test {

    @GetMapping("test")
    public String testmthod() {
        return "test";
    }

    /*文件下载*/
    @GetMapping("/download")
    public String downloadFile(HttpServletResponse response) {
        String fileName = "dalaoyang.jpeg";// 文件名

        if (fileName != null) {

            File file = null;
            try {
                file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/file/apache-tomcat-7.0.94.zip");
                //获取文件sha512码
                String hex = new DigestUtils(SHA_512).digestAsHex(file);
                System.out.println(hex);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //获取文件名
            String fileName1 = file.getName();
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName1);// 设置文件名
               // byte[] buffer = new byte[(int) file.length()];
                FileInputStream fis = null;
                OutputStream os =null;
              //  BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
               //     bis = new BufferedInputStream(fis);
                   os = response.getOutputStream();
                    //int i = bis.read(buffer);
                   /* while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }*/
                   FileCopyUtils.copy(fis,os);
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    /*if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }*/
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }if (os != null) {
                        try {
                            os.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }

    /*文件上传*/
    @PostMapping("upload")
    public static String uploadFile(MultipartFile[] file, String filesha512) {
        File filepath = new File("F:/static/images");
        if (!filepath.exists()) {
            filepath.mkdirs();
        }
        String path = "";
        for (MultipartFile multFile : file) {
            if (null != multFile && !multFile.isEmpty()) {

                //获取文件名
                File file2 = new File(multFile.getOriginalFilename());
                try {
                    //将mutipartFile类型转成File类型
                    FileUtils.copyInputStreamToFile(multFile.getInputStream(), file2);
                    //获取文件sha512码
                    String hex = new DigestUtils(SHA_512).digestAsHex(file2);
                    if (!filesha512.trim().equals(hex)) {
                        return "文件上传错误";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //获取文件名
                String originalFilename = multFile.getOriginalFilename();
                //生成uuid作为文件名称
                String uuiname = UUID.randomUUID().toString().replace("-", "");
                //获取文件类型
                String contentType = multFile.getContentType();
                //文件名称后缀名
                String substring = contentType.substring(contentType.indexOf("/") + 1);
                path = uuiname + "." + substring;
                try {
                    multFile.transferTo(new File(filepath + "/" + path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return "上传成功";
    }

    public static void main(String[] args) throws IOException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "static/file/apache-tomcat-7.0.94.zip");
       /* //File类型转换MultipartFile代码
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), file.getName(),
                ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
*/
        FileInputStream input = new FileInputStream(file);
        /*//获取文件类型
        String contentType = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), contentType, IOUtils.toByteArray(input));
        MultipartFile[] mf = new MultipartFile[3];
        mf[0] = multipartFile;
        String result = uploadFile(mf, "f08326e58bd5e611c8603f92a314b3f0d04d889c4e06cbbf33c32035eca3e12c527744fa58a90e500cb4e4f2a7fc702622176e67f4723ad3654ae78e574abb8ded");
        System.out.println(result);*/
        Resource re=new ClassPathResource("/static/file/u=659016637,3105969132&fm=11&gp=0.jpg");
        FileOutputStream os=new FileOutputStream(new File("d:/ss.jpg"));
      FileCopyUtils.copy(re.getInputStream(),os);

    }
}