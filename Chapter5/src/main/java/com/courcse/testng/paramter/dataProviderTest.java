package com.courcse.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @Author：见遇
 * @Date：2021-02-17 2:30 上午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
public class dataProviderTest {
    @Test(dataProvider = "data")
    public void testProviderTest(String name,int age){
        System.out.println("name = "+name+ "\n"+ "age = " +age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"张三",10},{"李四",20},{"王五",30}
        };
        return o;
    }
}
