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
        aService.service(entity);

        // The entity is referenced by the ThreadLocalMap in the Thread. So remove it.
        entity.getThreadLocal().remove();
        return "OK";
    }
}
