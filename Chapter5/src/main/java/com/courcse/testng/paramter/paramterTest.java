package com.courcse.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 2:12 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class paramterTest {
    @Test
    @Parameters({"name","age"})
    public void paramterTest1(String name, int age){
        System.out.println("name = "+name+ "\n"+ "age = " +age);
    }


}
