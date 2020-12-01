package com.zkw.springboot_project;

import com.zkw.springboot_project.controller.LoginController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootProjectApplicationTests {

    @Test
    public void test() {
        System.out.println(("----- method test ------"));
        String name = "yunfan";
        LoginController loginController;
        Assert.assertEquals("yunfan22", name);
    }




}
