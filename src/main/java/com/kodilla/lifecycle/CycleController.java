package com.kodilla.lifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CycleController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/create-bean")
    public String createBean() {
        ExampleBean exampleBean = applicationContext.getBean(ExampleBean.class);
        return "Bean 'ExampleBean' was created.";
    }
}
