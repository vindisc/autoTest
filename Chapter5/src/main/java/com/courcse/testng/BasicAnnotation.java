package com.courcse.testng;

import org.testng.annotations.*;

/**
 * @Author：见遇
 * @Date：2021-02-16 11:46 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class BasicAnnotation {
    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");

    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod 这是在测试方法前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod 这是在测试方法后运行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass 这是在类后运行的");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass 这是在类运行前运行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite测试套件");
    }

}
