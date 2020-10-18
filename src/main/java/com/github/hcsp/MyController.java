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
        Entity entity = new Entity();
        try {
            aService.service(entity);
        } finally {
            if (entity != null) {
                //使用ThreadLocal一定要调用remove()方法，否则会出现内存泄漏问题!
                entity.getThreadLocal().remove();
            }
        }
        return "OK";
    }
}
