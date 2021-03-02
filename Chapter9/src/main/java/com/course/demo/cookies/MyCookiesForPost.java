package com.course.demo.cookies;

import org.apache.commons.codec.StringEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Author：见遇
 * @Date：2021-02-28 9:41 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class MyCookiesForPost {
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
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        //拼接测试地址
        String testUrl = this.url+uri;

        //声明一个Client对象,用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();

        //声明一个方法,这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","meet");
        param.put("age","18");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加在方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //声明一个对象来进行响应结果的存储
        String result;

        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);

        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //处理信息,判断返回结果是否符合预期
        //将响应转换为json对象
        JSONObject resultJson = new JSONObject(result);

        //获取到结果的值
        String Success = (String) resultJson.get("success");
        String Status = (String) resultJson.get("status");

        //具体的判断返回结果的值
        Assert.assertEquals("success",Success);
        Assert.assertEquals("1",Status);
    }
}
