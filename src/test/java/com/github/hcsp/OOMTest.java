package com.github.hcsp;

import com.github.kevinsawicki.http.HttpRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OOMTest {
    @Autowired
    Environment environment;

    private String getUrl(String apiName) {
        // 获取集成测试的端口号
        return "http://localhost:" + environment.getProperty("local.server.port") + apiName;
    }


    @Test
    public void test() throws IOException, InterruptedException {
        // 进行自动化的用户登录、注销操作
        for (int i = 0; i < 100; ++i) {
            Thread.sleep(100);
            int statusCode = HttpRequest.get("http://localhost:" + environment.getProperty("local.server.port") + "/index")
                    .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                    .code();
            Assertions.assertEquals(200, statusCode);
        }
    }
}
