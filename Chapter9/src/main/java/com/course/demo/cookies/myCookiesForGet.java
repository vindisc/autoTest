package com.course.demo.cookies;

import com.sun.security.ntlm.Client;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author：见遇
 * @Date：2021-02-28 4:01 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class myCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;

        //从配置文件中 拼接测试的url
        String uri = bundle.getString("getCookies.url");
        String testUrl = this.url+uri;

        //测试逻辑代码
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient Client = new DefaultHttpClient();
        HttpResponse response = Client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //获取cookie信息
        this.store = Client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookie name = " + name + "\n" +
                    "Cookie value = " + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode = "+ statusCode);

        if (statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }

    }
}
