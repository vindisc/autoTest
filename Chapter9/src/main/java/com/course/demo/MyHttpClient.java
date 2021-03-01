package com.course.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @Author：见遇
 * @Date：2021-02-19 10:33 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        String result;  //用来存放结果
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet("http://www.taobao.com");
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);


    }
}
