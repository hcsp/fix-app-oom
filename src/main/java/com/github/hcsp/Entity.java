package com.github.hcsp;

public class Entity {
    private byte[] data = new byte[10 * 1024 * 1024];

    private ThreadLocal threadLocal = ThreadLocal.withInitial(() -> Entity.this);

    public ThreadLocal<Entity> getThreadLocal() {
        return threadLocal;
    }
}
