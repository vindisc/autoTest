package com.example.demo;

/**
 * @Author：见遇
 * @Date：2021-03-01 8:05 下午
 * @Version： 1.0
 * @Description: 高山仰止 景行行止 虽不能至 心向往之
 */
@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}