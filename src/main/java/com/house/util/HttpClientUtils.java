package com.house.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.CookieStore;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/2  14:01
 * @Decription:
 * @Modified:
 */
public class HttpClientUtils {

    public static CloseableHttpClient httpClient;
    public static CookieStore cookieStore = new BasicCookieStore();

    //post请求 带表单参数访问
    public static String postWithParam(String url, List param) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        String result = "";
//        List nvps = new ArrayList();
//        nvps.add(new BasicNameValuePair("interfaceVersion", ""));
//        nvps.add(new BasicNameValuePair("requestTime", "1"));
//        nvps.add(new BasicNameValuePair("loginPassword", ""));
//        nvps.add(new BasicNameValuePair("theName", "TEST"));
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //设置cookie
        httpPost.setEntity(new UrlEncodedFormEntity(param));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        try {
            int statusCode = response.getStatusLine().getStatusCode();
            result = EntityUtils.toString(response.getEntity());
            System.out.println(statusCode);
            System.out.println(result);
//            //添加断言
            Assert.assertEquals(200, statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    @Test
    public static void getDemo() throws IOException {
        //创建httppost对象
        HttpPost post = new HttpPost("https://www.baidu.com");
        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //设置参数
        List param = new ArrayList();
        param.add(new BasicNameValuePair("username","TEST"));
        param.add(new BasicNameValuePair("pwd","test"));
        post.setEntity(new UrlEncodedFormEntity(param));
        CloseableHttpResponse response = client.execute(post);

        String result  = EntityUtils.toString(response.getEntity());

        System.out.println(result);

    }


    @Test
    public static String postDemo() throws IOException {
        CloseableHttpResponse response = null;
        String jsonString = "";
        HttpPost post = new HttpPost("https://www.baidu.com");
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        //设置httpPost的请求头中的MIME类型为json
        post.setHeader("Content-Type","application/json");
        StringEntity entity = new StringEntity(jsonString,"utf-8");
        post.setEntity(entity);
        try {
             response = httpClient.execute(post);//执行请求返回结果
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return null;
            }
            HttpEntity responseentity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, "utf-8");
                return resultStr;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        } finally {
            if (response != null) {
                try {
                    response.close();//最后关闭response
                } catch (IOException e) {
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(Math.round(-1.5));
    }


}
