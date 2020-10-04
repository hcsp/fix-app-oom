package com.github.hcsp;

import org.springframework.stereotype.Service;

@Service
public class AService {
    public void service(Entity entity) {
        Entity e = entity.getThreadLocal().get();
        if (e != entity) {
            throw new RuntimeException();
        }
        entity.getThreadLocal().remove();
    }
}
