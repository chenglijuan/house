package com.house.util;

import com.house.config.TestConfig;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenglijuan
 * @Data: 2022/9/2  14:01
 * @Decription:
 * @Modified:
 */
public class HttpClientUtils {

    public static CloseableHttpClient httpClient  ;
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;

    }


}
