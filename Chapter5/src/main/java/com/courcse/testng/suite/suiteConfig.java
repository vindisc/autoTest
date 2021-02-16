package com.courcse.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * @Author：见遇
 * @Date：2021-02-17 12:13 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class suiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite运行啦");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行啦");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");

    }

    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
