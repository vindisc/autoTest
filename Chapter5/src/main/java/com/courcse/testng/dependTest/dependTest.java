package com.courcse.testng.dependTest;

import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 2:03 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class dependTest {
    @Test
    public void test1(){
        System.out.println("依赖测试用例1");
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("依赖测试用例2");
    }
}
