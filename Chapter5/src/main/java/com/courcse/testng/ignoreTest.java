package com.courcse.testng;

import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 12:49 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class ignoreTest {
    @Test
    public void ignoreTest1(){
        System.out.println("ignoreTest1 执行");
    }

    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("ignoreTest2 执行");
    }

    @Test(enabled = true)
    public void ignoreTest3(){
        System.out.println("ignoreTest3 执行");
    }
}
