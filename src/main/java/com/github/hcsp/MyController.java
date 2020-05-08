package com.github.hcsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    private final AService aService;

    @Autowired
    public MyController(AService blogService) {
        this.aService = blogService;
    }

    @GetMapping("/index")
    @ResponseBody
    public String index() {
        aService.service(new Entity());
        return "OK";
    }
}
