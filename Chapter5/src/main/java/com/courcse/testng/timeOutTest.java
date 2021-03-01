package com.courcse.testng;

import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 4:44 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class timeOutTest {
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }

}
