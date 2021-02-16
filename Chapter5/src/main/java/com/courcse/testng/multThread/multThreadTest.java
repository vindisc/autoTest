package com.courcse.testng.multThread;

import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 2:51 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class multThreadTest {

    @Test(invocationCount = 10)
    public void test(){
        System.out.println(1);
    }
}
