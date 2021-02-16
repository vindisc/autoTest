package com.courcse.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 1:01 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class groupsTest {
    @Test(groups ="分组1")
    public void test1(){
        System.out.println("这是分组1 test1()");
    }
    @Test(groups ="分组1")
    public void test2(){
        System.out.println("这是分组1 test2()");
    }
    @Test(groups ="分组1")
    public void test3(){
        System.out.println("这是分组1 test3()");
    }
    @Test(groups ="分组2")
    public void test4(){
        System.out.println("这是分组2 test4()");
    }
    @Test(groups ="分组2")
    public void test5(){
        System.out.println("这是分组2 test5()");
    }
    @BeforeGroups("分组1")
    public void beforeGroups1Test(){
        System.out.println("这是分组1测试之前运行的");
    }

    @AfterGroups("分组1")
    public void afterGroups1Test(){
        System.out.println("这是分组1测试之后运行的");
    }

    @BeforeGroups("分组2")
    public void beforeGroups2Test(){
        System.out.println("这是分组2测试之前运行的");
    }

    @AfterGroups("分组2")
    public void afterGroups2Test(){
        System.out.println("这是分组2测试之后运行的");
    }

}
