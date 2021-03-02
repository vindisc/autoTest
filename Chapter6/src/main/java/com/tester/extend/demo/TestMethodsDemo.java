package com.tester.extend.demo;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 5:46 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }
    @Test
    public void logDemo(){
        Reporter.log("这是自己写的日志");
        throw new RuntimeException("这是程序跑的时候的异常");

    }
}
